package uk.ac.hw.macs.pjbk.quizx;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity 
implements OnClickListener{
    private QuizApplication application;
    private Button historyButton;
    private Button mathsButton;
    private TextView summary;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        application = (QuizApplication) this.getApplication();

        historyButton = (Button) findViewById(R.id.history_button);
        historyButton.setOnClickListener(this);
        mathsButton = (Button) findViewById(R.id.maths_button);
        mathsButton.setOnClickListener(this);
        summary = (TextView) findViewById(R.id.overall_summary);
        generateSummary();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        generateSummary();
    }

    private void generateSummary()
    {
        summary.setText( application.getQuestionsCorrect() + " questions correct "
                         + application.getQuestionsAttempted() + " attempted.");
    }

    public void onClick(View arg0)
    {
        if ( arg0 == historyButton ) {
            Log.i("QUIZ", "History selected");
            Toast.makeText(getApplicationContext(), "History button pressed", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, uk.ac.hw.macs.pjbk.quizx.MultiChoiceQuestionsActivity.class));
        }
        if ( arg0 == mathsButton ) {
            Log.i("QUIZ", "Maths selected");
            startActivity(new Intent(this, uk.ac.hw.macs.pjbk.quizx.NumericQuestion.class));
        }
    }
}
