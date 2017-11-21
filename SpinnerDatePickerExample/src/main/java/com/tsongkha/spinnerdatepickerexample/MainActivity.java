package com.tsongkha.spinnerdatepickerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tsongkha.spinnerdatepicker.DatePicker;
import com.tsongkha.spinnerdatepicker.DatePickerDialog;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by rawsond on 25/08/17.
 */

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

	TextView dateTextView;
	Button dateButton;
	SimpleDateFormat simpleDateFormat;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dateButton = (Button) findViewById(R.id.set_date_button);
		dateTextView = (TextView) findViewById(R.id.date_textview);
		simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.US);
		dateButton.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				showDate(1980, 0, 1, R.style.DatePickerSpinner);
			}
		});
	}

	@Override public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		Calendar calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
		dateTextView.setText(simpleDateFormat.format(calendar.getTime()));
	}

	@VisibleForTesting void showDate(int year, int monthOfYear, int dayOfMonth, int spinnerTheme) {
		new SpinnerDatePickerDialogBuilder().context(MainActivity.this)
		                                    .callback(MainActivity.this)
		                                    .spinnerTheme(spinnerTheme)
		                                    .year(year)
		                                    .monthOfYear(monthOfYear)
		                                    .dayOfMonth(dayOfMonth)
		                                    .setMinDate(System.currentTimeMillis())
		                                    .setMaxDate(new GregorianCalendar(2018, 3, 21).getTimeInMillis())
		                                    .build()
		                                    .show();
	}
}