package com.discord.widgets.notice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import b.p.a.b;
import b.p.a.g;
import b.p.a.i;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.widgets.home.WidgetHome;
import d0.e0.c;
import d0.z.d.a0;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup {
    private static final int DEFAULT_AUTO_DISMISS_PERIOD_SECONDS = 5;
    public static final NoticePopup INSTANCE = new NoticePopup();

    private NoticePopup() {
    }

    public static final /* synthetic */ void access$cancelCountdown(NoticePopup noticePopup, ValueAnimator valueAnimator) {
        noticePopup.cancelCountdown(valueAnimator);
    }

    public static final /* synthetic */ void access$dismiss(NoticePopup noticePopup, String str) {
        noticePopup.dismiss(str);
    }

    public static final /* synthetic */ ValueAnimator access$getAutoDismissAnimator(NoticePopup noticePopup, Integer num, Function0 function0) {
        return noticePopup.getAutoDismissAnimator(num, function0);
    }

    private final void cancelCountdown(ValueAnimator autoDismissAnimator) {
        if (autoDismissAnimator != null) {
            autoDismissAnimator.cancel();
        }
        if (autoDismissAnimator != null) {
            autoDismissAnimator.end();
        }
    }

    private final void dismiss(String name) {
        ViewGroup viewGroup;
        b bVar;
        WeakReference<ViewGroup> weakReference = i.a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            m.checkNotNullExpressionValue(viewGroup, "it");
            int childCount = viewGroup.getChildCount();
            if (childCount >= 0) {
                int i = 0;
                while (true) {
                    if (viewGroup.getChildAt(i) instanceof b) {
                        View childAt = viewGroup.getChildAt(i);
                        Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                        bVar = (b) childAt;
                    } else {
                        bVar = null;
                    }
                    if (bVar != null && bVar.getWindowToken() != null) {
                        ViewCompat.animate(bVar).alpha(0.0f).withEndAction(new g(bVar));
                    }
                    if (i == childCount) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), name, 0L, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void enqueue$default(NoticePopup noticePopup, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Drawable drawable, String str2, Drawable drawable2, List list, String str3, Integer num, Drawable drawable3, Integer num2, List list2, Function1 function1, Function1 function2, int i, Object obj) {
        noticePopup.enqueue(str, charSequence, (i & 4) != 0 ? null : charSequence2, charSequence3, (i & 16) != 0 ? null : drawable, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : drawable2, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : drawable3, (i & 2048) != 0 ? 5 : num2, (i & 4096) != 0 ? d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)) : list2, (i & 8192) != 0 ? NoticePopup$enqueue$1.INSTANCE : function1, function2);
    }

    private final ValueAnimator getAutoDismissAnimator(Integer autoDismissPeriodSecs, Function0<Unit> onEnd) {
        if (autoDismissPeriodSecs == null) {
            return null;
        }
        ValueAnimator valueAnimatorOfInt = ObjectAnimator.ofInt(0, 1);
        NoticePopup$getAutoDismissAnimator$animatorListener$1 noticePopup$getAutoDismissAnimator$animatorListener$1 = new NoticePopup$getAutoDismissAnimator$animatorListener$1(onEnd);
        m.checkNotNullExpressionValue(valueAnimatorOfInt, "animator");
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setDuration(((long) autoDismissPeriodSecs.intValue()) * 1000);
        valueAnimatorOfInt.addListener(noticePopup$getAutoDismissAnimator$animatorListener$1);
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    public final void enqueue(String noticeName, CharSequence noticeTitle, CharSequence noticeSubtitle, CharSequence noticeBody, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, List<Sticker> noticeStickers, String noticeIconUrl, Integer noticeIconResId, Drawable noticeIconTopRight, Integer noticeAutoDismissPeriodSecs, List<? extends c<? extends AppComponent>> validScreens, Function1<? super View, Unit> onClickTopRightIcon, Function1<? super View, Unit> onClick) {
        m.checkNotNullParameter(noticeName, "noticeName");
        m.checkNotNullParameter(validScreens, "validScreens");
        m.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
        m.checkNotNullParameter(onClick, "onClick");
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice(noticeName, null, 0L, 1, false, validScreens, 1000L, false, 0L, new NoticePopup$enqueue$notice$1(onClick, noticeName, noticeAutoDismissPeriodSecs, noticeIconUrl, noticeIconResId, noticeBodyImageUrl, noticeBodyImageDrawable, noticeBodyBackgroundDrawable, noticeTitle, noticeSubtitle, noticeBody, noticeIconTopRight, noticeStickers, onClickTopRightIcon), 150, null));
    }
}
