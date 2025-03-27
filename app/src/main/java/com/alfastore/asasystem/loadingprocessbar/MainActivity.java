package com.alfastore.asasystem.loadingprocessbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progress1, progress2, progress3, progress4;
    private int progressStatus = 0, progressStatus2 = 0, progressStatus3 = 0, progressStatus4 = 0;
    private LottieAnimationView lottieprogress1, lottieprogress2, lottieprogress3,
            lottieprogressdone1, lottieprogressdone2, lottieprogressdone3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progress1 = findViewById(R.id.progress1);
        progress1.setMax(100);
        progress2 = findViewById(R.id.progress2);
        progress2.setMax(100);
        progress3 = findViewById(R.id.progress3);
        progress3.setMax(100);
        progress4 = findViewById(R.id.progress4);
        progress4.setMax(100);

        lottieprogress1 = findViewById(R.id.lottieprogress1);
        lottieprogress1.setScaleX(1.3f);
        lottieprogress1.setScaleY(1.3f);

        lottieprogress2 = findViewById(R.id.lottieprogress2);
        lottieprogress2.setScaleX(1.3f);
        lottieprogress2.setScaleY(1.3f);

        lottieprogress3 = findViewById(R.id.lottieprogress3);
        lottieprogress3.setScaleX(1.3f);
        lottieprogress3.setScaleY(1.3f);

        lottieprogressdone1 = findViewById(R.id.lottieprogressdone1);
        lottieprogressdone2 = findViewById(R.id.lottieprogressdone2);
        lottieprogressdone3 = findViewById(R.id.lottieprogressdone3);

        runProgressView1(true, true, true);
    }

    private void runProgressView1(boolean completeProgress1, boolean completeProgress2, boolean completeProgress3){
        Handler handler = new Handler(Looper.getMainLooper());

        new Thread(() -> {
            while (true) {
                progressStatus += 7;

                handler.post(() -> progress1.setProgress(progressStatus));
                if (!completeProgress1){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lottieprogress1.setVisibility(View.GONE);
                        }
                    });
                }

                if (progressStatus >= 100) {
                    if (completeProgress1){
                        Log.d("TAG", "runProgressView1: Complete");
                        runOnUiThread(() -> {
                            lottieprogressdone1.setScaleX(1.3f);
                            lottieprogressdone1.setScaleY(1.3f);
                            lottieprogressdone1.setVisibility(View.VISIBLE);
                            lottieprogressdone1.playAnimation();
                        });

                        runProgressView2(completeProgress2, completeProgress3);

                        break;
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lottieprogress1.setVisibility(View.VISIBLE);
                                lottieprogressdone1.setVisibility(View.GONE);

                                progressStatus = 0;
                            }
                        });

                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void runProgressView2(boolean completeProgress2, boolean completeProgress3){
        Handler handler = new Handler(Looper.getMainLooper());

        new Thread(() -> {
            while (true) {
                progressStatus2 += 7;

                handler.post(() -> progress2.setProgress(progressStatus2));
                if (!completeProgress2){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lottieprogress2.setVisibility(View.GONE);
                        }
                    });
                }

                if (progressStatus2 >= 100) {
                    if (completeProgress2){
                        Log.d("TAG", "runProgressView2: Complete");

                        runOnUiThread(() -> {
                            lottieprogressdone2.setScaleX(1.3f);
                            lottieprogressdone2.setScaleY(1.3f);
                            lottieprogressdone2.setVisibility(View.VISIBLE);
                            lottieprogressdone2.playAnimation();
                        });

                        runProgressView3(completeProgress3);

                        break;
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lottieprogress2.setVisibility(View.VISIBLE);
                                lottieprogressdone2.setVisibility(View.GONE);
                                progressStatus2 = 0;
                            }
                        });

                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void runProgressView3(boolean completeProgress3){
        Handler handler = new Handler(Looper.getMainLooper());

        new Thread(() -> {
            while (true) {
                progressStatus3 += 7;

                handler.post(() -> progress3.setProgress(progressStatus3));
                if (!completeProgress3){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lottieprogress3.setVisibility(View.GONE);
                        }
                    });
                }

                if (progressStatus3 >= 100) {
                    if (completeProgress3){
                        Log.d("TAG", "runProgressView3: Complete");

                        runOnUiThread(() -> {
                            lottieprogressdone3.setScaleX(1.3f);
                            lottieprogressdone3.setScaleY(1.3f);
                            lottieprogressdone3.setVisibility(View.VISIBLE);
                            lottieprogressdone3.playAnimation();
                        });

                        runProgressView4();

                        break;
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lottieprogress3.setVisibility(View.VISIBLE);
                                lottieprogressdone3.setVisibility(View.GONE);
                                progressStatus3 = 0;
                            }
                        });

                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void runProgressView4(){
        Handler handler = new Handler(Looper.getMainLooper());

        new Thread(() -> {
            while (true) {
                progressStatus4 += 7;

                handler.post(() -> progress4.setProgress(progressStatus4));

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}