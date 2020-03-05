import React, {Component} from 'react';
import {Text, View, Button, NativeModules, AppState} from 'react-native';
import 'react-native-gesture-handler';

const PIPVideo = NativeModules.PIPVideo;

export class App extends Component {
  state = {
    appState: AppState.currentState,
  };

  componentDidMount() {
    AppState.addEventListener('change', this._handleAppStateChange);
  }

  componentWillUnmount() {
    AppState.removeEventListener('change', this._handleAppStateChange);
  }

  _handleAppStateChange = nextAppState => {
    if (
      this.state.appState.match(/inactive|background/) &&
      nextAppState === 'active'
    ) {
      console.log('App has come to the foreground!');
    }
    this.setState({appState: nextAppState});
  };

  onClick = () => {
    this.props.navigation.navigate('SScreen2');
    PIPVideo.openPIP();
    // alert('HEY');
  };

  render() {
    return (
      <View>
        <Button title={'Start Video'} onPress={this.onClick} />
        <Text>Current state is: {this.state.appState}</Text>
      </View>
    );
  }
}

export default App;
