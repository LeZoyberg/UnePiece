import { Injectable } from '@angular/core';
import { Ile, Partie } from './model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PartieService } from './partie.service';

@Injectable({
  providedIn: 'root',
})
export class IleService {
  ile: Ile = new Ile();
  partie: Partie = new Partie();
  idIle!: number;

  constructor(private http: HttpClient, private partieService: PartieService) {}

  findAllFirstIlesNextMer(ordreMer: string): Observable<Ile[]> {
    return this.http.get<Ile[]>(`${environment.apiUrl}/ile/mer/${ordreMer}`);
  }

  findAllNextIlesSameMer(ordreMer: string, ordre: number): Observable<Ile[]> {
    return this.http.get<Ile[]>(
      `${environment.apiUrl}/ile/mer/${ordreMer}/${ordre}`
    );
  }

  findAll(): Observable<Ile[]> {
    return this.http.get<Ile[]>(`${environment.apiUrl}/ile`);
  }

  findById(id?: number): Observable<Ile> {
    return this.http.get<Ile>(`${environment.apiUrl}/ile/${id}`);
  }

  create(ile: Ile): Observable<Ile> {
    return this.http.post<Ile>(`${environment.apiUrl}/ile`, ile);
  }

  update(ile: Ile): Observable<Ile> {
    return this.http.put<Ile>(`${environment.apiUrl}/partie/${ile.id}`, ile);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/partie/${id}`);
  }

  determineIle(partie : Partie): Ile {
    if (partie.ile == undefined) {
      this.idIle = 1;
    } else {
      this.idIle = partie.ile.id as number;
    }

    this.findById(this.idIle).subscribe((resp) => {
      partie.ile = resp;
      (partie.ile.id as number) = this.idIle;
      console.log(
        '[subscribe dans determineIle()] : partie.ile :>> ',
        partie.ile
      );
      console.log(
        '[subscribe dans determineIle()] : partie :>> ',
        partie
      );
      this.partieService.update(partie).subscribe();
      this.ile = partie.ile as Ile;
    });
    return this.ile;
  }
}
