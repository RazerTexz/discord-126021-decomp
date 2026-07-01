package com.discord.utilities.view.validators;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: InputValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface InputValidator<T> {
    CharSequence getErrorMessage(T view);
}
