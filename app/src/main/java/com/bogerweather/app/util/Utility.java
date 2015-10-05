package com.bogerweather.app.util;

import android.text.TextUtils;

import com.bogerweather.app.model.BogerWeatherDB;
import com.bogerweather.app.model.City;
import com.bogerweather.app.model.County;
import com.bogerweather.app.model.Province;

/**
 * Created by Administrator on 2015/10/5.
 */
public class Utility {

    /*
    * 解析和处理服务器返回的省级数据
    * */
    public synchronized static boolean handleProvincesResponse
    (BogerWeatherDB bogerWeatherDB, String response) {

        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    bogerWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /*
    * 解析和处理服务器返回的市级数据
    * */
    public synchronized static boolean handleCitiesResponse
    (BogerWeatherDB bogerWeatherDB, String response, int provinceId) {

        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    bogerWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /*
    * 解析和处理服务器返回的县级数据
    * */
    public synchronized static boolean handleCountiesResponse
    (BogerWeatherDB bogerWeatherDB, String response, int cityId) {

        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    bogerWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }


}
