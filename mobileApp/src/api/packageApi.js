import axios from 'axios';

export default axios.create({
   baseURL: 'https://turistmo.herokuapp.com/', // prIT SHOULD GET CHANGED TO THE HEROKU URL.
   // baseURL: 'https://a9b042f36c00.ngrok.io/', // prIT SHOULD GET CHANGED TO THE HEROKU URL.

})

