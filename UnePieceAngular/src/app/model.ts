export class Partie {
  constructor(
    public id?: number,
    public dateDebut?: string,
    public termine?: boolean,
    public tresor?: number,
    public duree?: number,
    public membres?: Membre[],
    public ile?: Ile,
    public navire?: Navire,
    public joueur?: Joueur,
    public actions?: Action[]
  ) {}
}

export class Membre {
  constructor(
    public id?: number,
    public pv?: number,
    public power?: number,
    public pirate?: Pirate,
    public partie?: Partie
  ) {}
}

export class Pirate {
  constructor(
    public id?: number,
    public pv?: number,
    public power?: number,
    public prime?: number,
    public fruit?: boolean,
    public capitaine?: boolean,
    public nom?: string
  ) {}
}

export class Bateau {
  constructor(
    public id?: number,
    public nom?: string,
    public capacite?: number,
    public robustesse?: number,
    public prix?: number,
    public debut?: boolean
  ) {}
}

export class Navire {
  constructor(
    public id?: number,
    public robustesse?: number,
    public bateau?: Bateau
  ) {}
}

export class Ile {
  constructor(
    public id?: number,
    public nom?: string,
    public taverne?: boolean,
    public auberge?: boolean,
    public chantier?: boolean,
    public attente?: number,
    public ordre?: number,
    public mer?: string
  ) {}
}

export class Joueur {
    constructor(
    public id?: number,
    public login?: string,
    public password?: string,
    ) {}
    }

export class Action {
    constructor(
        public id?: number,
        public choix?: boolean,
        public degatNavire?: number,
        public degatMembre?: number,
        public tresor?: number,
        public event?: Evenement,
        public partie?: Partie
    ) {}
}

export class Evenement {
    constructor(
    public id?: number,
    public degatNavire?: number,
    public degatMembre?: number,
    public tresor?: number,
    public odyssee?: string,
    ) {}
    }