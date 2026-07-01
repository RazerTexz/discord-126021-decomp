package com.discord.utilities.view.text;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import android.widget.TextView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.i.a.f.e.o.f;
import com.discord.utilities.logging.Logger;
import d0.o;
import d0.t.h0;
import d0.t.k;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;
import s.a.h1;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LinkifiedTextView$ClickableSpanOnTouchListener implements View$OnTouchListener {
    private AtomicBoolean isClickHandled;
    private AtomicReference<Job> job;
    private final long longPressDelayInMs;
    private final Function2<View, String, Unit> onURLSpanClicked;

    /* JADX WARN: Multi-variable type inference failed */
    public LinkifiedTextView$ClickableSpanOnTouchListener(long j, Function2<? super View, ? super String, Unit> function2) {
        this.longPressDelayInMs = j;
        this.onURLSpanClicked = function2;
        this.isClickHandled = new AtomicBoolean(false);
        this.job = new AtomicReference<>();
    }

    public static final /* synthetic */ AtomicReference access$getJob$p(LinkifiedTextView$ClickableSpanOnTouchListener linkifiedTextView$ClickableSpanOnTouchListener) {
        return linkifiedTextView$ClickableSpanOnTouchListener.job;
    }

    public static final /* synthetic */ long access$getLongPressDelayInMs$p(LinkifiedTextView$ClickableSpanOnTouchListener linkifiedTextView$ClickableSpanOnTouchListener) {
        return linkifiedTextView$ClickableSpanOnTouchListener.longPressDelayInMs;
    }

    public static final /* synthetic */ AtomicBoolean access$isClickHandled$p(LinkifiedTextView$ClickableSpanOnTouchListener linkifiedTextView$ClickableSpanOnTouchListener) {
        return linkifiedTextView$ClickableSpanOnTouchListener.isClickHandled;
    }

    public static final /* synthetic */ void access$setClickHandled$p(LinkifiedTextView$ClickableSpanOnTouchListener linkifiedTextView$ClickableSpanOnTouchListener, AtomicBoolean atomicBoolean) {
        linkifiedTextView$ClickableSpanOnTouchListener.isClickHandled = atomicBoolean;
    }

    public static final /* synthetic */ void access$setJob$p(LinkifiedTextView$ClickableSpanOnTouchListener linkifiedTextView$ClickableSpanOnTouchListener, AtomicReference atomicReference) {
        linkifiedTextView$ClickableSpanOnTouchListener.job = atomicReference;
    }

    private final ClickableSpan[] getTouchedClickableSpans(TextView textView, MotionEvent motionEvent) {
        CharSequence text = textView.getText();
        if (!(text instanceof Spanned)) {
            text = null;
        }
        Spanned spanned = (Spanned) text;
        if (spanned == null) {
            return new ClickableSpan[0];
        }
        int scrollX = textView.getScrollX() + (((int) motionEvent.getX()) - textView.getTotalPaddingLeft());
        int scrollY = textView.getScrollY() + (((int) motionEvent.getY()) - textView.getTotalPaddingTop());
        Layout layout = textView.getLayout();
        if (layout == null) {
            return new ClickableSpan[0];
        }
        int lineForVertical = layout.getLineForVertical(scrollY);
        Layout layout2 = textView.getLayout();
        if (layout2 == null) {
            return new ClickableSpan[0];
        }
        float f = scrollX;
        int offsetForHorizontal = layout2.getOffsetForHorizontal(lineForVertical, f);
        float lineRight = textView.getLayout().getLineRight(lineForVertical);
        float lineLeft = textView.getLayout().getLineLeft(lineForVertical);
        if (f > lineRight || (scrollX >= 0 && f < lineLeft)) {
            return new ClickableSpan[0];
        }
        Object[] spans = spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        m.checkNotNullExpressionValue(spans, "spanned.getSpans(off, of…lickableSpan::class.java)");
        return (ClickableSpan[]) spans;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    /* JADX WARN: Code duplicated, block: B:64:0x0168  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        T t;
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(event, "event");
        TextView textView = (TextView) (!(view instanceof TextView) ? null : view);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        if (textView != null) {
            try {
                ClickableSpan[] touchedClickableSpans = getTouchedClickableSpans(textView, event);
                if (touchedClickableSpans != null) {
                    t = (ClickableSpan) k.firstOrNull(touchedClickableSpans);
                } else {
                    t = 0;
                }
                ref$ObjectRef.element = t;
            } catch (IndexOutOfBoundsException e) {
                Pair[] pairArr = new Pair[8];
                pairArr[0] = o.to(NotificationCompat$MessagingStyle$Message.KEY_TEXT, String.valueOf(textView != null ? textView.getText() : null));
                pairArr[1] = o.to("view_x", String.valueOf(textView != null ? Float.valueOf(textView.getX()) : null));
                pairArr[2] = o.to("view_y", String.valueOf(textView != null ? Float.valueOf(textView.getY()) : null));
                pairArr[3] = o.to("event_x", String.valueOf(event.getX()));
                pairArr[4] = o.to("event_y", String.valueOf(event.getY()));
                pairArr[5] = o.to("event_action", String.valueOf(event.getAction()));
                pairArr[6] = o.to("width", String.valueOf(textView != null ? Integer.valueOf(textView.getWidth()) : null));
                pairArr[7] = o.to("height", String.valueOf(textView != null ? Integer.valueOf(textView.getHeight()) : null));
                Map<String, String> mapMapOf = h0.mapOf(pairArr);
                Logger loggerAccess$getLogger$p = LinkifiedTextView$Companion.access$getLogger$p(LinkifiedTextView.Companion);
                String name = LinkifiedTextView$ClickableSpanOnTouchListener.class.getName();
                m.checkNotNullExpressionValue(name, "javaClass.name");
                loggerAccess$getLogger$p.e(name, "failed to get touched clickable spans", e, mapMapOf);
            }
        } else {
            t = 0;
            ref$ObjectRef.element = t;
        }
        if (((ClickableSpan) ref$ObjectRef.element) == null) {
            Job job = this.job.get();
            if (job != null) {
                f.t(job, null, 1, null);
            }
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.isClickHandled.set(false);
            Job job2 = this.job.get();
            if (job2 != null) {
                f.t(job2, null, 1, null);
            }
            if (((ClickableSpan) ref$ObjectRef.element) instanceof com.discord.utilities.spans.ClickableSpan) {
                Job jobH0 = f.H0(x0.j, k0.a, null, new LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1(this, new WeakReference(view), ref$ObjectRef, null), 2, null);
                ((h1) jobH0).n(false, true, new LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$$inlined$apply$lambda$1(jobH0, this));
                Job andSet = this.job.getAndSet(jobH0);
                if (andSet != null) {
                    f.t(andSet, null, 1, null);
                }
            }
        } else if (action == 1) {
            Job job3 = this.job.get();
            if (job3 != null) {
                f.t(job3, null, 1, null);
            }
            if (!this.isClickHandled.getAndSet(true)) {
                T t2 = ref$ObjectRef.element;
                if (((ClickableSpan) t2) instanceof URLSpan) {
                    Function2<View, String, Unit> function2 = this.onURLSpanClicked;
                    if (function2 != null) {
                        String url = ((URLSpan) ((ClickableSpan) t2)).getURL();
                        m.checkNotNullExpressionValue(url, "clickableSpan.url");
                        if (function2.invoke(view, url) == null) {
                            ((ClickableSpan) ref$ObjectRef.element).onClick(view);
                        }
                    } else {
                        ((ClickableSpan) ref$ObjectRef.element).onClick(view);
                    }
                } else {
                    ((ClickableSpan) t2).onClick(view);
                }
            }
        } else {
            if (action != 3) {
                return false;
            }
            Job job4 = this.job.get();
            if (job4 != null) {
                f.t(job4, null, 1, null);
            }
        }
        return true;
    }

    public /* synthetic */ LinkifiedTextView$ClickableSpanOnTouchListener(long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 500L : j, function2);
    }
}
