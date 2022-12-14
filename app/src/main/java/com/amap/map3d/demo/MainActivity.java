package com.amap.map3d.demo;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.amap.api.maps.MapsInitializer;
import com.amap.map3d.demo.basic.Animate_CameraActivity;
import com.amap.map3d.demo.basic.BasicMapActivity;
import com.amap.map3d.demo.basic.CameraActivity;
import com.amap.map3d.demo.basic.EventsActivity;
import com.amap.map3d.demo.basic.GestureSettingsActivity;
import com.amap.map3d.demo.basic.HeatMapActivity;
import com.amap.map3d.demo.basic.LayersActivity;
import com.amap.map3d.demo.basic.LimitBoundsActivity;
import com.amap.map3d.demo.basic.LogoSettingsActivity;
import com.amap.map3d.demo.basic.MapOptionActivity;
import com.amap.map3d.demo.basic.MinMaxZoomLevelActivity;
import com.amap.map3d.demo.overlay.HoneycombHeatMapActivity;
import com.amap.map3d.demo.overlay.ParticleMapActivity;
import com.amap.map3d.demo.overlay.ParticleWeatherMapActivity;
import com.amap.map3d.demo.basic.PoiClickActivity;
import com.amap.map3d.demo.basic.ScreenShotActivity;
import com.amap.map3d.demo.basic.TwoMapActivity;
import com.amap.map3d.demo.basic.UiSettingsActivity;
import com.amap.map3d.demo.basic.ViewPagerWithMapActivity;
import com.amap.map3d.demo.basic.ZoomActivity;
import com.amap.map3d.demo.basic.map.MapImpMethodActivity;
import com.amap.map3d.demo.busline.BusStationActivity;
import com.amap.map3d.demo.busline.BuslineActivity;
import com.amap.map3d.demo.cloud.CloudActivity;
import com.amap.map3d.demo.district.DistrictActivity;
import com.amap.map3d.demo.district.DistrictWithBoundaryActivity;
import com.amap.map3d.demo.geocoder.GeocoderActivity;
import com.amap.map3d.demo.geocoder.ReGeocoderActivity;
import com.amap.map3d.demo.indoor.IndoorMapActivity;
import com.amap.map3d.demo.inputtip.InputtipsActivity;
import com.amap.map3d.demo.listmap.MapListViewActivity;
import com.amap.map3d.demo.listmap.RecycleViewActivity;
import com.amap.map3d.demo.location.CustomLocationActivity;
import com.amap.map3d.demo.location.CustomLocationModeActivity;
import com.amap.map3d.demo.location.LocationModeSourceActivity;
import com.amap.map3d.demo.location.LocationModeSourceActivity_Old;
import com.amap.map3d.demo.offlinemap.OfflineMapActivity_Old;
import com.amap.map3d.demo.opengl.OpenglActivity;
import com.amap.map3d.demo.overlay.ArcActivity;
import com.amap.map3d.demo.overlay.BuildingOverlayActivity;
import com.amap.map3d.demo.overlay.CircleActivity;
import com.amap.map3d.demo.overlay.ColourfulPolylineActivity;
import com.amap.map3d.demo.overlay.CustomMarkerActivity;
import com.amap.map3d.demo.overlay.GeodesicActivity;
import com.amap.map3d.demo.overlay.GroundOverlayActivity;
import com.amap.map3d.demo.overlay.HoleActivity;
import com.amap.map3d.demo.overlay.InfoWindowActivity;
import com.amap.map3d.demo.overlay.MarkerActivity;
import com.amap.map3d.demo.overlay.MarkerAnimationActivity;
import com.amap.map3d.demo.overlay.MarkerClickActivity;
import com.amap.map3d.demo.overlay.MultiPointOverlayActivity;
import com.amap.map3d.demo.overlay.NavigateArrowOverlayActivity;
import com.amap.map3d.demo.overlay.PolygonActivity;
import com.amap.map3d.demo.overlay.PolylineActivity;
import com.amap.map3d.demo.overlay.ProvinceHoleActivity;
import com.amap.map3d.demo.poisearch.PoiAroundSearchActivity;
import com.amap.map3d.demo.poisearch.PoiIDSearchActivity;
import com.amap.map3d.demo.poisearch.PoiKeywordSearchActivity;
import com.amap.map3d.demo.poisearch.SubPoiSearchActivity;
import com.amap.map3d.demo.route.BusRouteActivity;
import com.amap.map3d.demo.route.DriveRouteActivity;
import com.amap.map3d.demo.route.DriveRoutePlanActivity;
import com.amap.map3d.demo.route.RideRouteActivity;
import com.amap.map3d.demo.route.RouteActivity;
import com.amap.map3d.demo.route.RouteDistanceActivity;
import com.amap.map3d.demo.route.TruckRouteActivity;
import com.amap.map3d.demo.route.WalkRouteActivity;
import com.amap.map3d.demo.routepoi.RoutePOIActivity;
import com.amap.map3d.demo.share.ShareActivity;
import com.amap.map3d.demo.smooth.SmoothMoveActivity;
import com.amap.map3d.demo.tools.CalculateDistanceActivity;
import com.amap.map3d.demo.tools.ContainsActivity;
import com.amap.map3d.demo.tools.CoordConverActivity;
import com.amap.map3d.demo.tools.GeoToScreenActivity;
import com.amap.map3d.demo.trace.TraceActivity;
import com.amap.map3d.demo.trace.TraceActivity_Simple;
import com.amap.map3d.demo.view.FeatureView;
import com.amap.map3d.demo.weather.WeatherSearchActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * AMapV2??????demo??????
 */
public final class MainActivity extends ListActivity {
	private static class DemoDetails {
		private final int titleId;
		private final int descriptionId;
		private final Class<? extends android.app.Activity> activityClass;

		public DemoDetails(int titleId, int descriptionId,
				Class<? extends android.app.Activity> activityClass) {
			super();
			this.titleId = titleId;
			this.descriptionId = descriptionId;
			this.activityClass = activityClass;
		}
	}

	//????????????????????????????????????????????????true???????????????????????????????????????????????????????????????
	private boolean needCheckBackLocation = false;
	//???????????????target > 28????????????????????????????????????????????????"????????????"???????????????
	private static String BACK_LOCATION_PERMISSION = "android.permission.ACCESS_BACKGROUND_LOCATION";

	private static class CustomArrayAdapter extends ArrayAdapter<DemoDetails> {
		public CustomArrayAdapter(Context context, DemoDetails[] demos) {
			super(context, R.layout.feature, R.id.title, demos);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			FeatureView featureView;
			if (convertView instanceof FeatureView) {
				featureView = (FeatureView) convertView;
			} else {
				featureView = new FeatureView(getContext());
			}
			DemoDetails demo = getItem(position);
			featureView.setTitleId(demo.titleId, demo.activityClass!=null);
			return featureView;
		}
	}

	private static final DemoDetails[] demos = {
//		            ????????????
			new DemoDetails(R.string.map_create, R.string.blank, null),
//			????????????
			new DemoDetails(R.string.basic_map, R.string.basic_description,
					BasicMapActivity.class),
//			????????????
			new DemoDetails(R.string.list_map, R.string.basic_description,
					MapListViewActivity.class),
//			????????????
			new DemoDetails(R.string.recycle_map, R.string.basic_description,
					RecycleViewActivity.class),
//			6?????????????????????
			new DemoDetails(R.string.basic_map_6, R.string.basic_description_temp,
					MapImpMethodActivity.class),
//			Fragment????????????
//			new DemoDetails(R.string.base_fragment_map, R.string.base_fragment_description,
//					BaseMapSupportFragmentActivity.class),
//			new DemoDetails(R.string.basic_texturemapview, R.string.basic_texturemapview_description,
//					TextureMapViewActivity.class),
			new DemoDetails(R.string.viewpager_map, R.string.viewpger_map_description,
					ViewPagerWithMapActivity.class),
//			???????????????
		    new DemoDetails(R.string.multi_inst, R.string.blank, 
		    		TwoMapActivity.class),
//		           ????????????
		    new DemoDetails(R.string.indoormap_demo, R.string.indoormap_description,
		            IndoorMapActivity.class),
//		    amapoptions????????????
		    new DemoDetails(R.string.mapOption_demo,
					R.string.mapOption_description, MapOptionActivity.class),
//-----------???????????????-----------------------------------------------------------------------------------------------
		    new DemoDetails(R.string.map_interactive, R.string.blank, null),
		    //???????????????????????????????????????????????????????????????
		    new DemoDetails(R.string.uisettings_demo,
					R.string.uisettings_description, UiSettingsActivity.class),
			//??????logo????????????
			new DemoDetails(R.string.logo,
					R.string.uisettings_description, LogoSettingsActivity.class),
			//????????????
			new DemoDetails(R.string.layers_demo, R.string.layers_description,
					LayersActivity.class),
			//???????????????????????????????????????????????????
			new DemoDetails(R.string.gesture,
					R.string.uisettings_description, GestureSettingsActivity.class),
			//?????????????????????????????????????????????
			new DemoDetails(R.string.events_demo, R.string.events_description,
					EventsActivity.class),
			//??????POI??????
			new DemoDetails(R.string.poiclick_demo,
					R.string.poiclick_description, PoiClickActivity.class),	
			//?????????????????????
			new DemoDetails(R.string.camera_demo, R.string.camera_description, 
					CameraActivity.class),
			//??????????????????
			new DemoDetails(R.string.animate_demo, R.string.animate_description,
					Animate_CameraActivity.class),
			//??????????????????	
			new DemoDetails(R.string.map_zoom, R.string.blank, ZoomActivity.class),

			//????????????
			new DemoDetails(R.string.screenshot_demo,
					R.string.screenshot_description, ScreenShotActivity.class),

			//?????????????????????????????????
			new DemoDetails(R.string.set_min_max_zoomlevel,
					R.string.set_min_max_zoomlevel_description, MinMaxZoomLevelActivity.class),

			//???????????????????????????
			new DemoDetails(R.string.limit_bounds,
					R.string.limit_bounds_description, LimitBoundsActivity.class),
//----------------------------------------------------------------------------------------------------------------------------------------
			//??????????????????	
			new DemoDetails(R.string.map_overlay, R.string.blank, null),
			//?????????
			new DemoDetails(R.string.marker_demo, R.string.marker_description,
					MarkerActivity.class),
			//marker????????????
			new DemoDetails(R.string.marker_click, R.string.marker_click,
					MarkerClickActivity.class),
			//Marker ????????????
			new DemoDetails(R.string.marker_animation_demo, R.string.marker_animation_description,
					MarkerAnimationActivity.class),
			//??????????????????????????????
			new DemoDetails(R.string.infowindow_demo, R.string.infowindow_demo, InfoWindowActivity.class),
			//??????????????????
			new DemoDetails(R.string.custommarker_demo, R.string.blank,
					CustomMarkerActivity.class),		
			//???????????????????????????
			new DemoDetails(R.string.locationmodesource_demo_old,R.string.locationmodesource_description,LocationModeSourceActivity_Old.class),
			new DemoDetails(R.string.locationmodesource_demo,R.string.locationmodesource_description,LocationModeSourceActivity.class),
			//????????????????????????????????????
			new DemoDetails(R.string.customlocation_demo,R.string.customlocation_demo,CustomLocationActivity.class),
			new DemoDetails(R.string.customlocationmode_demo,R.string.customlocationmode_demo,CustomLocationModeActivity.class),
			//?????????????????????
			new DemoDetails(R.string.polyline_demo,
					R.string.polyline_description, PolylineActivity.class),
			//?????????
			new DemoDetails(R.string.colourline_demo,
					R.string.colourline_description, ColourfulPolylineActivity.class),		
			//????????????
			new DemoDetails(R.string.geodesic_demo, R.string.geodesic_description,
					GeodesicActivity.class),		
//			????????????
			new DemoDetails(R.string.arc_demo, R.string.arc_description,
					ArcActivity.class),
			//???????????????????????????
			new DemoDetails(R.string.navigatearrow_demo,
					R.string.navigatearrow_description,
					NavigateArrowOverlayActivity.class),
			//?????????
			new DemoDetails(R.string.circle_demo, R.string.circle_description,
					CircleActivity.class),
		    //??????????????????
			new DemoDetails(R.string.polygon_demo,
					R.string.polygon_description, PolygonActivity.class),
			//???????????????
			new DemoDetails(R.string.heatmap_demo,
					R.string.heatmap_description, HeatMapActivity.class),
			//??????groundoverlay
			new DemoDetails(R.string.groundoverlay_demo,
					R.string.groundoverlay_description,GroundOverlayActivity.class),
			//??????opengl
			new DemoDetails(R.string.opengl_demo, R.string.opengl_description,
					OpenglActivity.class),
			//????????????????????????
			new DemoDetails(R.string.buildingoverlay, R.string.tileoverlay_demo,
					BuildingOverlayActivity.class),
			new DemoDetails(R.string.multipoint_demo, R.string.multipoint_description,
					MultiPointOverlayActivity.class),
			new DemoDetails(R.string.hole_demo, R.string.hole_decription,
					HoleActivity.class),
			new DemoDetails(R.string.province_hole_demo, R.string.province_hole_decription,
					ProvinceHoleActivity.class),
			new DemoDetails(R.string.particle_demo, R.string.particle_decription,
					ParticleMapActivity.class),
			new DemoDetails(R.string.particle_weather_demo, R.string.particle_weather_decription,
					ParticleWeatherMapActivity.class),
			new DemoDetails(R.string.show_honeycomb_heat_map_demo, R.string.show_honeycomb_heat_map_decription,
					HoneycombHeatMapActivity.class),
//-----------------------------------------------------------------------------------------------------------------------------------------------------
			//??????????????????
			new DemoDetails(R.string.search_data, R.string.blank, null),
			//???????????????
			new DemoDetails(R.string.poikeywordsearch_demo,
					R.string.poikeywordsearch_description,
					PoiKeywordSearchActivity.class),
			//????????????
			new DemoDetails(R.string.poiaroundsearch_demo,
					R.string.poiaroundsearch_description,
					PoiAroundSearchActivity.class),
//			ID??????
			new DemoDetails(R.string.poiidsearch_demo,
					R.string.poiidsearch_demo,
					PoiIDSearchActivity.class),
			//????????????
			new DemoDetails(R.string.routepoisearch_demo, 
					R.string.routepoisearch_demo, 
					RoutePOIActivity.class),
//			??????????????????
			new DemoDetails(R.string.inputtips_demo, R.string.inputtips_description,
					InputtipsActivity.class),
//			POI????????????
			new DemoDetails(R.string.subpoi_demo, R.string.subpoi_description,
					SubPoiSearchActivity.class),
//			????????????
			new DemoDetails(R.string.weather_demo,
					R.string.weather_description, WeatherSearchActivity.class),
//			????????????
			new DemoDetails(R.string.geocoder_demo,
					R.string.geocoder_description, GeocoderActivity.class),
//			???????????????
			new DemoDetails(R.string.regeocoder_demo,
					R.string.regeocoder_description, ReGeocoderActivity.class),
//			??????????????????
			new DemoDetails(R.string.district_demo,
					R.string.district_description, DistrictActivity.class),
//			?????????????????????
			new DemoDetails(R.string.district_boundary_demo,
					R.string.district_boundary_description,
					DistrictWithBoundaryActivity.class),
//			??????????????????
			new DemoDetails(R.string.busline_demo,
					R.string.busline_description, BuslineActivity.class),
//			??????????????????
			new DemoDetails(R.string.busstation_demo,
					R.string.blank, BusStationActivity.class),
//			??????
			new DemoDetails(R.string.cloud_demo, R.string.cloud_description,
					CloudActivity.class),
//			??????????????????
			new DemoDetails(R.string.search_route, R.string.blank, null),
//			????????????????????????
			new DemoDetails(R.string.route_drive, R.string.blank, DriveRouteActivity.class),
			//??????????????????????????????
			new DemoDetails(R.string.route_plan_drive, R.string.blank, DriveRoutePlanActivity.class),
//			????????????????????????
			new DemoDetails(R.string.route_walk, R.string.blank, WalkRouteActivity.class),
//			????????????????????????
			new DemoDetails(R.string.route_bus, R.string.blank, BusRouteActivity.class),
//			????????????????????????
			new DemoDetails(R.string.route_ride, R.string.blank, RideRouteActivity.class),
			new DemoDetails(R.string.route_truck, R.string.blank, TruckRouteActivity.class),
			new DemoDetails(R.string.route_distance, R.string.blank, RouteDistanceActivity.class),
//			route??????demo
			new DemoDetails(R.string.route_demo, R.string.route_description,
					RouteActivity.class),
//			????????????
			new DemoDetails(R.string.search_share, R.string.blank, null),		
			new DemoDetails(R.string.share_demo, R.string.share_description,
					ShareActivity.class),
			
//			????????????
			new DemoDetails(R.string.map_offline, R.string.blank, null),
			new DemoDetails(R.string.offlinemap_demo,
					R.string.offlinemap_description, OfflineMapActivity_Old.class),
			new DemoDetails(R.string.offlinemap_ui_demo,
					R.string.offlinemap_ui_description, com.amap.api.maps.offlinemap.OfflineMapActivity.class),
			
//			??????????????????
			new DemoDetails(R.string.map_tools, R.string.blank, null),

//			???????????????????????????????????????
			new DemoDetails(R.string.coordconvert_demo, R.string.coordconvert_demo, CoordConverActivity.class),
//			???????????????????????????????????????
			new DemoDetails(R.string.convertgeo2point_demo, R.string.convertgeo2point_demo, GeoToScreenActivity.class),
//			?????????????????????
			new DemoDetails(R.string.calculateLineDistance, R.string.calculateLineDistance, CalculateDistanceActivity.class),
//			??????????????????????????????
			new DemoDetails(R.string.contains_demo, R.string.contains_demo, ContainsActivity.class),


//			??????????????????
			new DemoDetails(R.string.map_expand, R.string.blank, null),
//			????????????
			new DemoDetails(R.string.trace_demo, R.string.trace_description, TraceActivity.class),
			new DemoDetails(R.string.trace_demo_simple, R.string.trace_description_simple, TraceActivity_Simple.class),
//			????????????
			new DemoDetails(R.string.smooth_move_demo, R.string.smooth_move_description, SmoothMoveActivity.class)



	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(Build.VERSION.SDK_INT > 28
				&& getApplicationContext().getApplicationInfo().targetSdkVersion > 28) {
			needPermissions = new String[] {
					Manifest.permission.ACCESS_COARSE_LOCATION,
					Manifest.permission.ACCESS_FINE_LOCATION,
					Manifest.permission.WRITE_EXTERNAL_STORAGE,
					Manifest.permission.READ_EXTERNAL_STORAGE,
					Manifest.permission.READ_PHONE_STATE,
					BACK_LOCATION_PERMISSION
			};
			needCheckBackLocation = true;
		}
		setContentView(R.layout.main_activity);
		setTitle("3D??????Demo" + MapsInitializer.getVersion());
		ListAdapter adapter = new CustomArrayAdapter(
				this.getApplicationContext(), demos);
		setListAdapter(adapter);
		privacyCompliance();
	}

	private void privacyCompliance() {
		MapsInitializer.updatePrivacyShow(MainActivity.this,true,true);
		SpannableStringBuilder spannable = new SpannableStringBuilder("\"??????????????????XXX??????????????????????????????????????????????????????????????????XXX?????????????????????????????????????????????\n1.????????????????????????????????????????????????????????????????????????????????????\n2.?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\n3.?????????????????????????????????????????????????????????????????????\n4.???????????????????????????????????????????????????????????????????????????????????????\n");
		spannable.setSpan(new ForegroundColorSpan(Color.BLUE), 35, 42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		new AlertDialog.Builder(this)
				.setTitle("????????????(??????????????????)")
				.setMessage(spannable)
				.setPositiveButton("??????", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						MapsInitializer.updatePrivacyAgree(MainActivity.this,true);
					}
				})
				.setNegativeButton("?????????", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						MapsInitializer.updatePrivacyAgree(MainActivity.this,false);
					}
				})
				.show();
	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		System.exit(0);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		DemoDetails demo = (DemoDetails) getListAdapter().getItem(position);
		if (demo.activityClass != null) {
			Log.i("MY","demo!=null");
			startActivity(new Intent(this.getApplicationContext(),
					demo.activityClass));
		}

	}



	/*************************************** ????????????******************************************************/

	/**
	 * ?????????????????????????????????
	 */
	protected String[] needPermissions = {
			Manifest.permission.ACCESS_COARSE_LOCATION,
			Manifest.permission.ACCESS_FINE_LOCATION,
			Manifest.permission.WRITE_EXTERNAL_STORAGE,
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.READ_PHONE_STATE,
			BACK_LOCATION_PERMISSION
	};

	private static final int PERMISSON_REQUESTCODE = 0;

	/**
	 * ????????????????????????????????????????????????
	 */
	private boolean isNeedCheck = true;

	@Override
	protected void onResume() {
		try{
			super.onResume();
			if (Build.VERSION.SDK_INT >= 23) {
				if (isNeedCheck) {
					checkPermissions(needPermissions);
				}
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	/**
	 * @param
	 * @since 2.5.0
	 */
	@TargetApi(23)
	private void checkPermissions(String... permissions) {
		try{
			if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
				List<String> needRequestPermissonList = findDeniedPermissions(permissions);
				if (null != needRequestPermissonList
						&& needRequestPermissonList.size() > 0) {
					try {
						String[] array = needRequestPermissonList.toArray(new String[needRequestPermissonList.size()]);
						Method method = getClass().getMethod("requestPermissions", new Class[]{String[].class, int.class});
						method.invoke(this, array, 0);
					} catch (Throwable e) {

					}
				}
			}

		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	/**
	 * ?????????????????????????????????????????????
	 *
	 * @param permissions
	 * @return
	 * @since 2.5.0
	 */
	@TargetApi(23)
	private List<String> findDeniedPermissions(String[] permissions) {
		try{
			List<String> needRequestPermissonList = new ArrayList<String>();
			if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
				for (String perm : permissions) {
					if (checkMySelfPermission(perm) != PackageManager.PERMISSION_GRANTED
							|| shouldShowMyRequestPermissionRationale(perm)) {
						if(!needCheckBackLocation
								&& BACK_LOCATION_PERMISSION.equals(perm)) {
							continue;
						}
						needRequestPermissonList.add(perm);
					}
				}
			}
			return needRequestPermissonList;
		}catch(Throwable e){
			e.printStackTrace();
		}
		return null;
	}

	private int checkMySelfPermission(String perm) {
		try {
			Method method = getClass().getMethod("checkSelfPermission", new Class[]{String.class});
			Integer permissionInt = (Integer) method.invoke(this, perm);
			return permissionInt;
		} catch (Throwable e) {
		}
		return -1;
	}

	private boolean shouldShowMyRequestPermissionRationale(String perm) {
		try {
			Method method = getClass().getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class});
			Boolean permissionInt = (Boolean) method.invoke(this, perm);
			return permissionInt;
		} catch (Throwable e) {
		}
		return false;
	}

	/**
	 * ??????????????????????????????????????????
	 *
	 * @param grantResults
	 * @return
	 * @since 2.5.0
	 */
	private boolean verifyPermissions(int[] grantResults) {
		try{
			for (int result : grantResults) {
				if (result != PackageManager.PERMISSION_GRANTED) {
					return false;
				}
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
		return true;
	}

	@TargetApi(23)
	public void onRequestPermissionsResult(int requestCode,
										   String[] permissions, int[] paramArrayOfInt) {
		try{
			if (Build.VERSION.SDK_INT >= 23) {
				if (requestCode == PERMISSON_REQUESTCODE) {
					if (!verifyPermissions(paramArrayOfInt)) {
						showMissingPermissionDialog();
						isNeedCheck = false;
					}
				}
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	/**
	 * ??????????????????
	 *
	 * @since 2.5.0
	 */
	private void showMissingPermissionDialog() {
		try{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("??????");
			builder.setMessage("?????????????????????????????????\\n\\n?????????\\\"??????\\\"-\\\"??????\\\"-??????????????????");

			// ??????, ????????????
			builder.setNegativeButton("??????",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							try{
								finish();
							} catch (Throwable e) {
								e.printStackTrace();
							}
						}
					});

			builder.setPositiveButton("??????",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							try {
								startAppSettings();
							} catch (Throwable e) {
								e.printStackTrace();
							}
						}
					});

			builder.setCancelable(false);

			builder.show();
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	/**
	 * ?????????????????????
	 *
	 * @since 2.5.0
	 */
	private void startAppSettings() {
		try{
			Intent intent = new Intent(
					Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
			intent.setData(Uri.parse("package:" + getPackageName()));
			startActivity(intent);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
