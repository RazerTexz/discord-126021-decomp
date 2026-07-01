package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build$VERSION;
import android.text.Layout$Alignment;
import android.text.PrecomputedText;
import android.text.PrecomputedText$Params;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.StaticLayout$Builder;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';

    @NonNull
    @GuardedBy("sLock")
    private static Executor sExecutor;
    private static final Object sLock = new Object();

    @NonNull
    private final int[] mParagraphEnds;

    @NonNull
    private final PrecomputedTextCompat$Params mParams;

    @NonNull
    private final Spannable mText;

    @Nullable
    private final PrecomputedText mWrapped;

    private PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull PrecomputedTextCompat$Params precomputedTextCompat$Params, @NonNull int[] iArr) {
        this.mText = new SpannableString(charSequence);
        this.mParams = precomputedTextCompat$Params;
        this.mParagraphEnds = iArr;
        this.mWrapped = null;
    }

    @SuppressLint({"NewApi"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        PrecomputedText$Params precomputedText$Params;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(precomputedTextCompat$Params);
        try {
            TraceCompat.beginSection("PrecomputedText");
            if (Build$VERSION.SDK_INT >= 29 && (precomputedText$Params = precomputedTextCompat$Params.mWrapped) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, precomputedText$Params), precomputedTextCompat$Params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int iIndexOf = TextUtils.indexOf(charSequence, LINE_FEED, i, length);
                i = iIndexOf < 0 ? length : iIndexOf + 1;
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            if (Build$VERSION.SDK_INT >= 23) {
                StaticLayout$Builder.obtain(charSequence, 0, charSequence.length(), precomputedTextCompat$Params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(precomputedTextCompat$Params.getBreakStrategy()).setHyphenationFrequency(precomputedTextCompat$Params.getHyphenationFrequency()).setTextDirection(precomputedTextCompat$Params.getTextDirection()).build();
            } else {
                new StaticLayout(charSequence, precomputedTextCompat$Params.getTextPaint(), Integer.MAX_VALUE, Layout$Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return new PrecomputedTextCompat(charSequence, precomputedTextCompat$Params, iArr);
        } finally {
            TraceCompat.endSection();
        }
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull PrecomputedTextCompat$Params precomputedTextCompat$Params, @Nullable Executor executor) {
        PrecomputedTextCompat$PrecomputedTextFutureTask precomputedTextCompat$PrecomputedTextFutureTask = new PrecomputedTextCompat$PrecomputedTextFutureTask(precomputedTextCompat$Params, charSequence);
        if (executor == null) {
            synchronized (sLock) {
                if (sExecutor == null) {
                    sExecutor = Executors.newFixedThreadPool(1);
                }
                executor = sExecutor;
            }
        }
        executor.execute(precomputedTextCompat$PrecomputedTextFutureTask);
        return precomputedTextCompat$PrecomputedTextFutureTask;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.mText.charAt(i);
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphCount() {
        return Build$VERSION.SDK_INT >= 29 ? this.mWrapped.getParagraphCount() : this.mParagraphEnds.length;
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphEnd(@IntRange(from = 0) int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        return Build$VERSION.SDK_INT >= 29 ? this.mWrapped.getParagraphEnd(i) : this.mParagraphEnds[i];
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphStart(@IntRange(from = 0) int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build$VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphStart(i);
        }
        if (i == 0) {
            return 0;
        }
        return this.mParagraphEnds[i - 1];
    }

    @NonNull
    public PrecomputedTextCompat$Params getParams() {
        return this.mParams;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.mText;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.mText.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.mText.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.mText.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build$VERSION.SDK_INT >= 29 ? (T[]) this.mWrapped.getSpans(i, i2, cls) : (T[]) this.mText.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.mText.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build$VERSION.SDK_INT >= 29) {
            this.mWrapped.removeSpan(obj);
        } else {
            this.mText.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build$VERSION.SDK_INT >= 29) {
            this.mWrapped.setSpan(obj, i, i2, i3);
        } else {
            this.mText.setSpan(obj, i, i2, i3);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.mText.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.mText.toString();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        this.mText = precomputedText;
        this.mParams = precomputedTextCompat$Params;
        this.mParagraphEnds = null;
        this.mWrapped = Build$VERSION.SDK_INT < 29 ? null : precomputedText;
    }
}
