package com.discord.widgets.settings.profile;

import android.view.MotionEvent;
import androidx.cardview.widget.CardView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$onViewBound$2 extends o implements Function1<MotionEvent, Boolean> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$onViewBound$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(MotionEvent motionEvent) {
        return Boolean.valueOf(invoke2(motionEvent));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            TextInputLayout textInputLayout = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
            int width = textInputLayout.getWidth();
            TextInputLayout textInputLayout2 = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
            int height = textInputLayout2.getHeight();
            int[] iArr = new int[2];
            WidgetEditUserOrGuildMemberProfile.access$getBinding$p(this.this$0).d.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            if (rawX < ((float) i) || rawX > ((float) (i + width)) || rawY < ((float) i2) || rawY > ((float) (i2 + height))) {
                CardView cardView = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(this.this$0).f2640b;
                m.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
                if (cardView.getVisibility() == 0) {
                    WidgetEditUserOrGuildMemberProfile.access$setCurrentBioFromEditor(this.this$0);
                }
            }
        }
        return false;
    }
}
