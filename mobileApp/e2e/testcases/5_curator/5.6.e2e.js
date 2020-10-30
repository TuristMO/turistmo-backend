import {AppSO} from "../../screens/AppSO";
import {SplashSO} from "../../screens/SplashSO";
import {SignupSO} from "../../screens/SignupSO";
import {SigninSO} from "../../screens/SigninSO";
import {sleep} from "../../helpers";

const {device, expect, element, by, waitFor} = require('detox');

describe('TuristMO', () => {

    let appSO = new AppSO();
    let splashSO = new SplashSO();
    let signinSO = new SigninSO();
    let signupSO = new SignupSO();

    beforeAll(async ()=>{
        await device.launchApp({ permissions: { location: 'never' } });
    })

    beforeEach(async () => {
        await device.reloadReactNative();
        //await device.disableSynchronization();
    });

    it('5.6 Visa gömd text i signup & signin-formulär', async () => {

        await appSO.tapCuratorTab();
        await splashSO.tapGetStartedButton();
        await signinSO.tapSignupButton();   //Also expects visibility
        await signupSO.fillEmail("minemailadress@domain.co.uk");
        await signupSO.waitToHaveTextById("signupEmail", "minemailadress@domain.co.uk");
        await signupSO.fillPassword("123456");
        await signupSO.fillConfirmPassword("123456");
        await signupSO.tapById("signupShowHideToggle");
        await signupSO.waitToHaveTextById("signupPassword", "123456");
        await signupSO.waitToHaveTextById("confirmPassword", "123456");

        await signupSO.tapGoBackArrow();

        await splashSO.tapGetStartedButton();  //Also expects visibility
        await signinSO.fillSigninEmail("minemailadress@domain.co.uk");
        await signupSO.waitToHaveTextById("signinEmail", "minemailadress@domain.co.uk");
        await signinSO.fillPassword("123456");
        await signinSO.tapById("signinShowHideToggle");
        await signinSO.waitToHaveTextById("signinPassword", "123456");

    });

});