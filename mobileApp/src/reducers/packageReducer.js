import {
  GET_PACKAGES,
  GET_PACKAGES_TRAVEL,
  GET_PACKAGES_FOOD,
  GET_PACKAGES_CULTURE,
  GET_PACKAGES_BUSINESS,
  GET_PACKAGES_SUCCESS,
  GET_PACKAGES_FROM_CURATOR,
  GET_PACKAGE_BY_GUID,
  GET_PACKAGES_BY_CURATOR_GUID,
  POST_PACKAGES,
  POST_PACKAGES_ERROR,
  POST_PACKAGES_SUCCESS,
  DELETE_PACKAGES_ERROR,
  DELETE_PACKAGES_SUCCESS,
  LOADING,
} from "../actions/types";

const initialState = {
  packages: [],
  packagesTravel: [],
  packagesFood: [],
  packagesCulture: [],
  packagesBusiness: [],
  packagesByCuratorGuid: [],
  packagesBelongingToCurator: [],
  packageByGuid: {},
  postPackages: {}, //Curator object with packages
  loading: true,
  packagesFound: false,
  packageErrorMessage:'',
  packageSuccessMessage:'',
  deletePackageErrorMessage:'',
  deletePackageSuccessMessage:'',
}      // []

export default (state = initialState, action) => {
  switch (action.type) {
    case GET_PACKAGES:
      return { ...state,packages: action.payload, loading: false }
    case GET_PACKAGES_SUCCESS:
      return { ...state,packagesFound: action.payload, loading: false }
    case GET_PACKAGES_TRAVEL:
      return { ...state,packagesTravel: action.payload, loading: false }
    case GET_PACKAGES_FOOD:
      return { ...state,packagesFood: action.payload, loading: false }
    case GET_PACKAGES_CULTURE:
      return { ...state,packagesCulture: action.payload, loading: false }
    case GET_PACKAGES_BUSINESS:
      return { ...state,packagesBusiness: action.payload, loading: false }
    case GET_PACKAGES_BY_CURATOR_GUID:
      return { ...state,packagesByCuratorGuid: action.payload, loading: false }
    case GET_PACKAGE_BY_GUID:
      return { ...state,packageByGuid: action.payload, loading: false }
    case GET_PACKAGES_FROM_CURATOR:
      return { ...state,packagesBelongingToCurator: action.payload, loading: false }
    case POST_PACKAGES:
      return { ...state,postPackages: action.payload, loading: false }
    case POST_PACKAGES_ERROR:
      return { ...state,packageErrorMessage: action.payload, loading: false }
    case POST_PACKAGES_SUCCESS:
      return { ...state,packageSuccessMessage: action.payload, loading: false }
    case DELETE_PACKAGES_ERROR:
      return { ...state,deletePackageErrorMessage: action.payload, loading: false }
    case DELETE_PACKAGES_SUCCESS:
      return { ...state,deletePackageSuccessMessage: action.payload, loading: false }
    case LOADING:
      return { ...state, loading: action.payload, packageErrorMessage: '',packageSuccessMessage: '' }
    default:
      return state;
  }
}
