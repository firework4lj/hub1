package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Disablerain implements Listener{

	
	public Disablerain(Main Main) {
	}

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(e.toWeatherState()){
		e.setCancelled(true);
		}
	}
}
