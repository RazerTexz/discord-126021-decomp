package com.discord.app;

import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: compiled from: AppTransitionActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppTransitionActivity extends AppCompatActivity {
    public static boolean j;
    public AppTransitionActivity$a k = AppTransitionActivity$Transition.TYPE_SLIDE_POP_VERTICAL.getAnimations();

    public final void a(boolean z2, boolean z3) {
        AppTransitionActivity$a appTransitionActivity$a;
        if (z2 && z3) {
            return;
        }
        if ((z2 || z3) && (appTransitionActivity$a = this.k) != null) {
            overridePendingTransition(z3 ? appTransitionActivity$a.a : appTransitionActivity$a.c, z3 ? appTransitionActivity$a.f2082b : appTransitionActivity$a.d);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        j = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a(j, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a(j, true);
        j = false;
    }
}
