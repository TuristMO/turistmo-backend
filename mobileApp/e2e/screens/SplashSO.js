import {Utility} from "../Utility";

const {device, expect, element, by, waitFor} = require('detox');

export class SplashSO extends Utility {

    async clickGetStartedButton(timeout) {
        await this.toBeVisibleById("getStarted", timeout);
        await this.tapById("getStarted");
    }

}