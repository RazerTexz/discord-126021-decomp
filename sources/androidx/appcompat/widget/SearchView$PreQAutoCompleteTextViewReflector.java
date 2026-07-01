package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.os.Build$VERSION;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$PreQAutoCompleteTextViewReflector {
    private Method mDoAfterTextChanged;
    private Method mDoBeforeTextChanged;
    private Method mEnsureImeVisible;

    @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
    public SearchView$PreQAutoCompleteTextViewReflector() {
        this.mDoBeforeTextChanged = null;
        this.mDoAfterTextChanged = null;
        this.mEnsureImeVisible = null;
        preApi29Check();
        try {
            Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.mDoBeforeTextChanged = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        try {
            Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.mDoAfterTextChanged = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
            this.mEnsureImeVisible = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused3) {
        }
    }

    private static void preApi29Check() {
        if (Build$VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }

    public void doAfterTextChanged(AutoCompleteTextView autoCompleteTextView) {
        preApi29Check();
        Method method = this.mDoAfterTextChanged;
        if (method != null) {
            try {
                method.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public void doBeforeTextChanged(AutoCompleteTextView autoCompleteTextView) {
        preApi29Check();
        Method method = this.mDoBeforeTextChanged;
        if (method != null) {
            try {
                method.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public void ensureImeVisible(AutoCompleteTextView autoCompleteTextView) {
        preApi29Check();
        Method method = this.mEnsureImeVisible;
        if (method != null) {
            try {
                method.invoke(autoCompleteTextView, Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
    }
}
