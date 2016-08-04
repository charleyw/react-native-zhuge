import {NativeModules} from 'react-native';

const ZhuGe = NativeModules.ZhuGe;

export const {identify, track} = ZhuGe;
export default ZhuGe;