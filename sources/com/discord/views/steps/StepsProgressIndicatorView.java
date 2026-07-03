package com.discord.views.steps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StepsProgressIndicatorView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepsProgressIndicatorView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int totalStepCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsProgressIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        setOrientation(0);
    }

    /* JADX INFO: renamed from: a */
    public final void m8608a() {
        removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i = this.totalStepCount;
        for (int i2 = 0; i2 < i; i2++) {
            View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.steps_progress_indicator_dot_view, (ViewGroup) this, false);
            addView(viewInflate);
            Objects.requireNonNull(viewInflate, "rootView");
        }
    }

    public final void setCurrentStepIndex(int currentStepIndex) {
        if (currentStepIndex >= this.totalStepCount) {
            Logger.d$default(AppLog.f14950g, "Current step cannot be greater than the total step count", null, 2, null);
            return;
        }
        if (getChildCount() != this.totalStepCount) {
            m8608a();
        }
        int i = this.totalStepCount;
        int i2 = 0;
        while (i2 < i) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof TextView)) {
                childAt = null;
            }
            TextView textView = (TextView) childAt;
            if (textView != null) {
                textView.setEnabled(i2 <= currentStepIndex);
                if (i2 == currentStepIndex) {
                    textView.setTextSize(12.0f);
                    textView.setText(String.valueOf(currentStepIndex + 1));
                    textView.setSelected(true);
                } else {
                    textView.setTextSize(0.0f);
                    textView.setText((CharSequence) null);
                    textView.setSelected(false);
                }
            }
            i2++;
        }
    }

    public final void setTotalStepCount(int totalStepCount) {
        this.totalStepCount = totalStepCount;
        m8608a();
        setCurrentStepIndex(0);
    }
}
