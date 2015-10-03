package com.bogerweather.app.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bogerweather.app.db.BogerWeatherOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/4.
 */
public class BogerWeatherDB {


    /*
    *  数据库名
    * */
    public static final String DB_NAME = "boger_weather";

    /*
    * 数据库版本
    * */
    public static final int VERSION = 1;

    private static BogerWeatherDB bogerWeatherDB;

    private SQLiteDatabase db;

    /*
    * 将构造方法私有化
    * */
    private BogerWeatherDB(Context context) {
        BogerWeatherOpenHelper dbHelper = new BogerWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    /*
    * 获取BogerWeatherDB的实例
    * */
    public synchronized static BogerWeatherDB getInstance(Context context) {
        if (bogerWeatherDB == null) {
            bogerWeatherDB = new BogerWeatherDB(context);
        }
        return bogerWeatherDB;
    }

    /*
    * 将Province实例存储到数据库
    * */

    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            db.insert("Province", null, values);

        }
    }

    /*
    * 从数据库读取全国所有的省份信息
    * */
    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            } while (cursor.moveToNext());
        }
        if ((cursor != null)) {
            cursor.close();
        }
        return list;

    }

     /*
    * 将City实例存储到数据库
    * */

    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityName());
            values.put("city_code", city.getCityCode());
            db.insert("City", null, values);

        }
    }

    /*
    * 从数据库读取全国所有的城市信息
    * */
    public List<City> loadCities() {
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                list.add(city);
            } while (cursor.moveToNext());
        }
        if ((cursor != null)) {
            cursor.close();
        }
        return list;

    }

    /*
    * 将County实例存储到数据库
    * */

    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCountyName());
            values.put("county_code", county.getCountyCode());
            db.insert("County", null, values);

        }
    }

    /*
    * 从数据库读取全国所有的县信息
    * */
    public List<County> loadCounties() {
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                list.add(county);
            } while (cursor.moveToNext());
        }
        if ((cursor != null)) {
            cursor.close();
        }
        return list;

    }

}
