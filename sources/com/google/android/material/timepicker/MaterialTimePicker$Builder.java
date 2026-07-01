package com.google.android.material.timepicker;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTimePicker$Builder {
    private int inputMode;
    private CharSequence titleText;
    private TimeModel time = new TimeModel(0, 0, 10, 0);
    private int titleTextResId = 0;

    public static /* synthetic */ TimeModel access$000(MaterialTimePicker$Builder materialTimePicker$Builder) {
        return materialTimePicker$Builder.time;
    }

    public static /* synthetic */ int access$100(MaterialTimePicker$Builder materialTimePicker$Builder) {
        return materialTimePicker$Builder.inputMode;
    }

    public static /* synthetic */ int access$200(MaterialTimePicker$Builder materialTimePicker$Builder) {
        return materialTimePicker$Builder.titleTextResId;
    }

    public static /* synthetic */ CharSequence access$300(MaterialTimePicker$Builder materialTimePicker$Builder) {
        return materialTimePicker$Builder.titleText;
    }

    @NonNull
    public MaterialTimePicker build() {
        return MaterialTimePicker.access$1000(this);
    }

    @NonNull
    public MaterialTimePicker$Builder setHour(@IntRange(from = 0, to = 23) int i) {
        TimeModel timeModel = this.time;
        timeModel.p = i >= 12 ? 1 : 0;
        timeModel.m = i;
        return this;
    }

    @NonNull
    public MaterialTimePicker$Builder setInputMode(int i) {
        this.inputMode = i;
        return this;
    }

    @NonNull
    public MaterialTimePicker$Builder setMinute(@IntRange(from = 0, to = 60) int i) {
        TimeModel timeModel = this.time;
        Objects.requireNonNull(timeModel);
        timeModel.n = i % 60;
        return this;
    }

    @NonNull
    public MaterialTimePicker$Builder setTimeFormat(int i) {
        TimeModel timeModel = this.time;
        int i2 = timeModel.m;
        int i3 = timeModel.n;
        TimeModel timeModel2 = new TimeModel(0, 0, 10, i);
        this.time = timeModel2;
        timeModel2.n = i3 % 60;
        timeModel2.p = i2 >= 12 ? 1 : 0;
        timeModel2.m = i2;
        return this;
    }

    @NonNull
    public MaterialTimePicker$Builder setTitleText(@StringRes int i) {
        this.titleTextResId = i;
        return this;
    }

    @NonNull
    public MaterialTimePicker$Builder setTitleText(@Nullable CharSequence charSequence) {
        this.titleText = charSequence;
        return this;
    }
}
