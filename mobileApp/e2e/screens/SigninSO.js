import {Utility} from "../Utility";

const {device, expect, element, by, waitFor} = require('detox');

export class SigninSO extends Utility {

    async tapSigninButton(timeout) {
        await this.toBeVisibleById("signinSignin", timeout);
        await this.tapById("signinSignin");
    }

    async tapSignupButton(timeout) {
        await this.toBeVisibleById("signinSignUp", timeout);
        await this.tapById("signinSignUp");
    }
/*
    async clickGoBackArrow(timeout) {
        await this.toBeVisibleById("foo", timeout);
        await this.tapById("foo");
    }
    */


    async fillSigninEmail(inputText, timeout = 10000) {
        await this.toBeVisibleById("signinEmail", timeout);
        await this.replaceTextById("signinEmail", inputText);
    }

    async fillPassword(inputText, timeout = 10000) {
        await this.toBeVisibleById("signinPassword", timeout);
        await this.replaceTextById("signinPassword", inputText);
    }
    /*
    async toggleEyeHiddenCharacters(timeout = 10000) {
        await this.toBeVisibleById("foo", timeout);
        await this.tapById("foo")
    }
     */



}