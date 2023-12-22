import { AbstractControl, FormGroup, ValidationErrors, ValidatorFn } from '@angular/forms';

export function confirmEqualValidator(main: string, confirm: string) {
    /*
    return (ctrl: AbstractControl): null | ValidationErrors => {
        if (!ctrl.get(main) || !ctrl.get(confirm)) {
            return {
                confirmEqual: 'Invalid control names'
            };
        }
        const mainValue = ctrl.get(main)!.value;
        const confirmValue = ctrl.get(confirm)!.value;
        
        return mainValue === confirmValue ? null : {
            confirmEqual: {
                main: mainValue,
                confirm: confirmValue
            }
        };
    };
    */

    return (formGroup: FormGroup) => {
        console.log('validator');
        const control = formGroup.controls[main];
        const matchingControl = formGroup.controls[confirm];
        if (matchingControl.errors && !matchingControl.errors['confirmEqual']) {
            return;
        }
        if (control.value !== matchingControl.value) {
            matchingControl.setErrors({ confirmEqual: true });
        } else {
            matchingControl.setErrors(null);
        }
    };


}