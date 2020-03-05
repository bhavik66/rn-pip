import React, {Component} from 'react';
import {Text, View, Button} from 'react-native';

export class SScreen2 extends Component {
  render() {
    return (
      <View>
        <Button
          title={'SCREEN 3'}
          onPress={() => this.props.navigation.navigate('SScreen3')}
        />
        <Text> Stack Screen 2 </Text>
      </View>
    );
  }
}

export default SScreen2;
