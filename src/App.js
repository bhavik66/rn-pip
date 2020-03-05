import React from 'react';
import {createAppContainer} from 'react-navigation';
import {createDrawerNavigator} from 'react-navigation-drawer';
import {createStackNavigator} from 'react-navigation-stack';

import Home from './Home';
import DScreen1 from './DScreen1';
import DScreen2 from './DScreen2';
import DScreen3 from './DScreen3';

import SScreen1 from './SScreen1';
import SScreen2 from './SScreen2';

const MyDrawerNavigator = createDrawerNavigator({
  Home: {
    screen: Home,
  },
  DScreen1: {
    screen: DScreen1,
  },
  DScreen2: {
    screen: DScreen2,
  },
  DScreen3: {
    screen: DScreen3,
  },
});

const MyStackNavigator = createStackNavigator({
  Home: {
    screen: MyDrawerNavigator,
  },
  SScreen1: {
    screen: SScreen1,
  },
  SScreen2: {
    screen: SScreen2,
  },
});

export default createAppContainer(MyStackNavigator);
