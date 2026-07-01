package com.discord.utilities.view.text;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView$BufferType;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.utilities.logging.Logger;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LinkifiedTextView extends SimpleDraweeSpanTextView {
    public static final LinkifiedTextView$Companion Companion = new LinkifiedTextView$Companion(null);
    private static final Lazy logger$delegate = g.lazy(LinkifiedTextView$Companion$logger$2.INSTANCE);
    private static Function2<? super View, ? super String, Unit> onURLSpanClicked;

    public LinkifiedTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public LinkifiedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LinkifiedTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ Lazy access$getLogger$cp() {
        return logger$delegate;
    }

    public static final /* synthetic */ Function2 access$getOnURLSpanClicked$cp() {
        return onURLSpanClicked;
    }

    public static final /* synthetic */ void access$setOnURLSpanClicked$cp(Function2 function2) {
        onURLSpanClicked = function2;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView$BufferType type) {
        m.checkNotNullParameter(type, "type");
        try {
            super.setText(text, type);
        } catch (AndroidRuntimeException e) {
            if (e instanceof PackageManager$NameNotFoundException) {
                setAutoLinkMask(0);
                super.setText(text, type);
            } else {
                Log.w(LinkifiedTextView.class.toString(), "could not setText()", e);
                setText((CharSequence) null);
            }
        } catch (Exception e2) {
            if (new IntRange(24, 25).contains(Build$VERSION.SDK_INT)) {
                Logger.e$default(LinkifiedTextView$Companion.access$getLogger$p(Companion), "Unable to linkify text", e2, null, 4, null);
            } else {
                super.setText((CharSequence) null, type);
            }
        }
        setMovementMethod(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "ctx");
        setOnTouchListener(new LinkifiedTextView$ClickableSpanOnTouchListener(0L, onURLSpanClicked, 1, null));
    }
}
