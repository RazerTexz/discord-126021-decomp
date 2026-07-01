package com.discord.utilities.stateful;

import android.app.Activity;
import android.view.LayoutInflater;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.databinding.ViewDialogConfirmationBinding;
import d0.z.d.m;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews$FragmentOnBackPressedHandler {
    private final Activity activity;
    private final AtomicBoolean discardConfirmed;
    private final Function0<Boolean> hasAnythingChanged;

    public StatefulViews$FragmentOnBackPressedHandler(Activity activity, Function0<Boolean> function0) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(function0, "hasAnythingChanged");
        this.activity = activity;
        this.hasAnythingChanged = function0;
        this.discardConfirmed = new AtomicBoolean(false);
    }

    public static final /* synthetic */ AtomicBoolean access$getDiscardConfirmed$p(StatefulViews$FragmentOnBackPressedHandler statefulViews$FragmentOnBackPressedHandler) {
        return statefulViews$FragmentOnBackPressedHandler.discardConfirmed;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Function0<Boolean> getHasAnythingChanged() {
        return this.hasAnythingChanged;
    }

    public final boolean onBackPressed() {
        if (!this.hasAnythingChanged.invoke().booleanValue() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(this.activity));
        m.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
        AlertDialog alertDialogCreate = new AlertDialog$Builder(this.activity).setView(viewDialogConfirmationBindingB.a).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(acti…logBinding.root).create()");
        viewDialogConfirmationBindingB.d.setText(2131888486);
        viewDialogConfirmationBindingB.e.setText(2131888489);
        viewDialogConfirmationBindingB.f2185b.setOnClickListener(new StatefulViews$FragmentOnBackPressedHandler$onBackPressed$1(alertDialogCreate));
        viewDialogConfirmationBindingB.c.setText(2131893499);
        viewDialogConfirmationBindingB.c.setOnClickListener(new StatefulViews$FragmentOnBackPressedHandler$onBackPressed$2(this, alertDialogCreate));
        alertDialogCreate.show();
        return true;
    }
}
