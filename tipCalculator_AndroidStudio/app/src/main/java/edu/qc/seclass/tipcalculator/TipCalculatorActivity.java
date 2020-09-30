package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCompute = (Button) findViewById(R.id.buttonCompute);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
                EditText partySizeValue = (EditText) findViewById(R.id.partySizeValue);
                TextView fifteenPercentTipValue = (TextView) findViewById(R.id.fifteenPercentTipValue);
                TextView fifteenPercentTotalValue = (TextView) findViewById(R.id.fifteenPercentTotalValue);
                TextView twentyPercentTipValue = (TextView) findViewById(R.id.twentyPercentTipValue);
                TextView twentyPercentTotalValue = (TextView) findViewById(R.id.twentyPercentTotalValue);
                TextView twentyFivePercentTipValue = (TextView) findViewById(R.id.twentyFivePercentTipValue);
                TextView twentyFivePercentTotalValue = (TextView) findViewById(R.id.twentyFivePercentTotalValue);

                String cav = checkAmountValue.getText().toString();
                String psv = partySizeValue.getText().toString();

                if (cav.matches("") || psv.matches("")) {
                    Toast.makeText(getBaseContext(), "Enter both values!" , Toast.LENGTH_SHORT ).show();
                    return;
                }

                int check = Integer.parseInt(cav);
                int party = Integer.parseInt(psv);

                if((check <= 0 || party <= 0) || (party >= check)){
                    Toast.makeText(getBaseContext(), "Empty or Invalid Value(s)!" , Toast.LENGTH_SHORT ).show();
                    return;
                }

                int checkSplit = (int) Math.round(check/party);

                //15% tip
                int fifteenTipResult = (int) Math.round(checkSplit * .15);
                int fifteenTotalResult = checkSplit + fifteenTipResult;

                //20% tip
                int twentyTipResult = (int) Math.round(checkSplit * .20);
                int twentyTotalResult = checkSplit + twentyTipResult;

                //25% tip
                int twentyFiveTipResult = (int) Math.round(checkSplit * .25);
                int twentyFiveTotalResult = checkSplit + twentyFiveTipResult;

                fifteenPercentTipValue.setText("$" + fifteenTipResult);
                fifteenPercentTotalValue.setText("$" + fifteenTotalResult);

                twentyPercentTipValue.setText("$" + twentyTipResult);
                twentyPercentTotalValue.setText("$" + twentyTotalResult);

                twentyFivePercentTipValue.setText("$" + twentyFiveTipResult);
                twentyFivePercentTotalValue.setText("$" + twentyFiveTotalResult);

            }
        });
    }
}
