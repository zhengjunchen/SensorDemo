package com.czj.sensordemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/**
 * 传感器
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);





        SensorEventListener linstener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener(linstener, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    public void printAllSensor(){
        //获得传感器管理器
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //通过传感器管理器来获取手机上所有的传感器
        List<Sensor> listSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        //打印所有的传感器的公司名称和传感器名字
        for (Sensor sensor: listSensor) {
            Log.e("TAG", "传感器公司名：" + sensor.getVendor() + " 传感器名称：" + sensor.getName());
        }

    }
}
