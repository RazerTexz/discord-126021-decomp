package com.discord.views.steps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import b.a.i.y3;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StepsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepsView extends RelativeLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final y3 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public StepsView$d pagerAdapter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public ViewPager2$OnPageChangeCallback pagerAdapterChangeCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_steps, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.steps_button_container;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.steps_button_container);
        if (linearLayout != null) {
            i = R$id.steps_cancel;
            TextView textView = (TextView) viewInflate.findViewById(R$id.steps_cancel);
            if (textView != null) {
                i = R$id.steps_close;
                ImageView imageView = (ImageView) viewInflate.findViewById(R$id.steps_close);
                if (imageView != null) {
                    i = R$id.steps_done;
                    LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(R$id.steps_done);
                    if (loadingButton != null) {
                        i = R$id.steps_next;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.steps_next);
                        if (materialButton != null) {
                            i = R$id.steps_progress_indicator;
                            StepsProgressIndicatorView stepsProgressIndicatorView = (StepsProgressIndicatorView) viewInflate.findViewById(R$id.steps_progress_indicator);
                            if (stepsProgressIndicatorView != null) {
                                i = R$id.steps_title;
                                TextView textView2 = (TextView) viewInflate.findViewById(R$id.steps_title);
                                if (textView2 != null) {
                                    i = R$id.steps_viewpager;
                                    ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R$id.steps_viewpager);
                                    if (viewPager2 != null) {
                                        y3 y3Var = new y3((RelativeLayout) viewInflate, linearLayout, textView, imageView, loadingButton, materialButton, stepsProgressIndicatorView, textView2, viewPager2);
                                        m.checkNotNullExpressionValue(y3Var, "ViewStepsBinding.inflate…rom(context), this, true)");
                                        this.binding = y3Var;
                                        setIsLoading(false);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(StepsView$d adapter, Function0<Unit> onClose, Function1<? super Integer, Unit> onPageSelected) {
        m.checkNotNullParameter(adapter, "adapter");
        m.checkNotNullParameter(onClose, "onClose");
        m.checkNotNullParameter(onPageSelected, "onPageSelected");
        this.pagerAdapter = adapter;
        ViewPager2 viewPager2 = this.binding.i;
        m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        viewPager2.setAdapter(this.pagerAdapter);
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.pagerAdapterChangeCallback;
        if (viewPager2$OnPageChangeCallback != null) {
            this.binding.i.unregisterOnPageChangeCallback(viewPager2$OnPageChangeCallback);
        }
        ViewPager2 viewPager3 = this.binding.i;
        StepsView$e stepsView$e = new StepsView$e(this, onPageSelected, onClose);
        this.pagerAdapterChangeCallback = stepsView$e;
        viewPager3.registerOnPageChangeCallback(stepsView$e);
        c(0, onClose);
        this.binding.g.setTotalStepCount(adapter.a.size());
    }

    public final void b(int index) {
        if (index >= 0) {
            StepsView$d stepsView$d = this.pagerAdapter;
            if (index < (stepsView$d != null ? stepsView$d.getItemCount() : 0)) {
                ViewPager2 viewPager2 = this.binding.i;
                m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
                viewPager2.setCurrentItem(index);
            }
        }
    }

    public final void c(int position, Function0<Unit> onClose) {
        List<? extends StepsView$b> list;
        this.binding.d.setOnClickListener(new StepsView$f(onClose));
        StepsView$d stepsView$d = this.pagerAdapter;
        if (stepsView$d == null || (list = stepsView$d.a) == null) {
            return;
        }
        ViewPager2 viewPager2 = this.binding.i;
        m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        viewPager2.setUserInputEnabled(list.get(position).i);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.stepsCancel");
        textView.setText(getContext().getString(list.get(position).f2843b));
        this.binding.e.setText(getContext().getString(list.get(position).c));
        MaterialButton materialButton = this.binding.f;
        m.checkNotNullExpressionValue(materialButton, "binding.stepsNext");
        materialButton.setText(getContext().getString(list.get(position).a));
        this.binding.f.setOnClickListener(new StepsView$a(0, position, this, list));
        this.binding.c.setOnClickListener(new StepsView$g(this, list, position, onClose));
        boolean z2 = true;
        this.binding.e.setOnClickListener(new StepsView$a(1, position, list, onClose));
        StepsView$d stepsView$d2 = this.pagerAdapter;
        boolean z3 = stepsView$d2 != null && position == stepsView$d2.getItemCount() - 1;
        MaterialButton materialButton2 = this.binding.f;
        m.checkNotNullExpressionValue(materialButton2, "binding.stepsNext");
        materialButton2.setVisibility(!z3 && list.get(position).g ? 0 : 8);
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.stepsCancel");
        textView2.setVisibility(!z3 && list.get(position).h ? 0 : 8);
        LoadingButton loadingButton = this.binding.e;
        m.checkNotNullExpressionValue(loadingButton, "binding.stepsDone");
        loadingButton.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout = this.binding.f236b;
        m.checkNotNullExpressionValue(linearLayout, "binding.stepsButtonContainer");
        MaterialButton materialButton3 = this.binding.f;
        m.checkNotNullExpressionValue(materialButton3, "binding.stepsNext");
        if (!(materialButton3.getVisibility() == 0)) {
            TextView textView3 = this.binding.c;
            m.checkNotNullExpressionValue(textView3, "binding.stepsCancel");
            if (!(textView3.getVisibility() == 0)) {
                LoadingButton loadingButton2 = this.binding.e;
                m.checkNotNullExpressionValue(loadingButton2, "binding.stepsDone");
                if (!(loadingButton2.getVisibility() == 0)) {
                    z2 = false;
                }
            }
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
    }

    public final void setIsDoneButtonEnabled(boolean isEnabled) {
        LoadingButton loadingButton = this.binding.e;
        m.checkNotNullExpressionValue(loadingButton, "binding.stepsDone");
        loadingButton.setEnabled(isEnabled);
    }

    public final void setIsLoading(boolean isLoading) {
        this.binding.e.setIsLoading(isLoading);
    }

    public final void setIsNextButtonEnabled(boolean isEnabled) {
        MaterialButton materialButton = this.binding.f;
        m.checkNotNullExpressionValue(materialButton, "binding.stepsNext");
        materialButton.setEnabled(isEnabled);
    }

    public final void setIsTitleVisible(boolean isVisible) {
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.stepsTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            StepsProgressIndicatorView stepsProgressIndicatorView = this.binding.g;
            m.checkNotNullExpressionValue(stepsProgressIndicatorView, "binding.stepsProgressIndicator");
            stepsProgressIndicatorView.setVisibility(8);
        }
    }

    public final void setStepProgressIndicatorVisible(boolean isVisible) {
        StepsProgressIndicatorView stepsProgressIndicatorView = this.binding.g;
        m.checkNotNullExpressionValue(stepsProgressIndicatorView, "binding.stepsProgressIndicator");
        stepsProgressIndicatorView.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            TextView textView = this.binding.h;
            m.checkNotNullExpressionValue(textView, "binding.stepsTitle");
            textView.setVisibility(8);
        }
    }

    public final void setTitle(String title) {
        m.checkNotNullParameter(title, "title");
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.stepsTitle");
        textView.setText(title);
    }
}
