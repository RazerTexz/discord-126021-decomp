package com.discord.widgets.notice;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetNoticePopupBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tapadoo.alerter.C11198R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p007b.p483p.p484a.C5271a;
import p007b.p483p.p484a.C5279i;
import p007b.p483p.p484a.InterfaceC5280j;
import p007b.p483p.p484a.RunnableC5277g;
import p007b.p483p.p484a.RunnableC5278h;
import p007b.p483p.p484a.ViewOnClickListenerC5272b;
import p007b.p483p.p484a.ViewOnTouchListenerC5282l;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Integer $noticeAutoDismissPeriodSecs;
    public final /* synthetic */ CharSequence $noticeBody;
    public final /* synthetic */ Drawable $noticeBodyBackgroundDrawable;
    public final /* synthetic */ Drawable $noticeBodyImageDrawable;
    public final /* synthetic */ String $noticeBodyImageUrl;
    public final /* synthetic */ Integer $noticeIconResId;
    public final /* synthetic */ Drawable $noticeIconTopRight;
    public final /* synthetic */ String $noticeIconUrl;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ List $noticeStickers;
    public final /* synthetic */ CharSequence $noticeSubtitle;
    public final /* synthetic */ CharSequence $noticeTitle;
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ Function1 $onClickTopRightIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticePopup$enqueue$notice$1(Function1 function1, String str, Integer num, String str2, Integer num2, String str3, Drawable drawable, Drawable drawable2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Drawable drawable3, List list, Function1 function2) {
        super(1);
        this.$onClick = function1;
        this.$noticeName = str;
        this.$noticeAutoDismissPeriodSecs = num;
        this.$noticeIconUrl = str2;
        this.$noticeIconResId = num2;
        this.$noticeBodyImageUrl = str3;
        this.$noticeBodyImageDrawable = drawable;
        this.$noticeBodyBackgroundDrawable = drawable2;
        this.$noticeTitle = charSequence;
        this.$noticeSubtitle = charSequence2;
        this.$noticeBody = charSequence3;
        this.$noticeIconTopRight = drawable3;
        this.$noticeStickers = list;
        this.$onClickTopRightIcon = function2;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(final FragmentActivity fragmentActivity) {
        ViewOnClickListenerC5272b viewOnClickListenerC5272b;
        View view;
        ViewGroup viewGroup;
        Sticker sticker;
        Window window;
        int childCount;
        ViewOnClickListenerC5272b viewOnClickListenerC5272b2;
        Window window2;
        C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C5279i c5279i = new C5279i(null);
        View decorView = (fragmentActivity == null || (window2 = fragmentActivity.getWindow()) == null) ? null : window2.getDecorView();
        if (!(decorView instanceof ViewGroup)) {
            decorView = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) decorView;
        if (viewGroup2 != null && (childCount = viewGroup2.getChildCount()) >= 0) {
            int i = 0;
            while (true) {
                if (viewGroup2.getChildAt(i) instanceof ViewOnClickListenerC5272b) {
                    View childAt = viewGroup2.getChildAt(i);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                    viewOnClickListenerC5272b2 = (ViewOnClickListenerC5272b) childAt;
                } else {
                    viewOnClickListenerC5272b2 = null;
                }
                if (viewOnClickListenerC5272b2 != null && viewOnClickListenerC5272b2.getWindowToken() != null) {
                    ViewCompat.animate(viewOnClickListenerC5272b2).alpha(0.0f).withEndAction(new RunnableC5277g(viewOnClickListenerC5272b2));
                }
                if (i == childCount) {
                    break;
                }
                i++;
            }
        }
        if (fragmentActivity == null || (window = fragmentActivity.getWindow()) == null) {
            viewOnClickListenerC5272b = null;
        } else {
            View decorView2 = window.getDecorView();
            Objects.requireNonNull(decorView2, "null cannot be cast to non-null type android.view.ViewGroup");
            C5279i.f14367a = new WeakReference<>((ViewGroup) decorView2);
            View decorView3 = window.getDecorView();
            C12238m.checkNotNullExpressionValue(decorView3, "it.decorView");
            Context context = decorView3.getContext();
            C12238m.checkNotNullExpressionValue(context, "it.decorView.context");
            viewOnClickListenerC5272b = new ViewOnClickListenerC5272b(context, C5419R.layout.widget_notice_popup, null, 0, 12);
        }
        c5279i.f14368b = viewOnClickListenerC5272b;
        int themedColor = ColorCompat.getThemedColor(fragmentActivity, C5419R.attr.colorBackgroundTertiary);
        ViewOnClickListenerC5272b viewOnClickListenerC5272b3 = c5279i.f14368b;
        if (viewOnClickListenerC5272b3 != null) {
            viewOnClickListenerC5272b3.setAlertBackgroundColor(themedColor);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b4 = c5279i.f14368b;
        if (viewOnClickListenerC5272b4 != null) {
            LinearLayout linearLayout = (LinearLayout) viewOnClickListenerC5272b4.m7465c(C11198R.d.llAlertBackground);
            C12238m.checkNotNullExpressionValue(linearLayout, "it");
            linearLayout.setOnTouchListener(new ViewOnTouchListenerC5282l(linearLayout, new C5271a(viewOnClickListenerC5272b4)));
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b5 = c5279i.f14368b;
        if (viewOnClickListenerC5272b5 != null) {
            viewOnClickListenerC5272b5.setVibrationEnabled(false);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b6 = c5279i.f14368b;
        if (viewOnClickListenerC5272b6 != null) {
            viewOnClickListenerC5272b6.setEnableInfiniteDuration(true);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b7 = c5279i.f14368b;
        if (viewOnClickListenerC5272b7 != null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(viewOnClickListenerC5272b7.getContext(), C5419R.anim.anim_slide_in_down);
            C12238m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…lert?.context, animation)");
            viewOnClickListenerC5272b7.setEnterAnimation$alerter_release(animationLoadAnimation);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Function1 function1 = NoticePopup$enqueue$notice$1.this.$onClick;
                C12238m.checkNotNullExpressionValue(view2, "view");
                function1.invoke(view2);
                NoticePopup.INSTANCE.dismiss(NoticePopup$enqueue$notice$1.this.$noticeName);
            }
        };
        C12238m.checkNotNullParameter(onClickListener, "onClickListener");
        ViewOnClickListenerC5272b viewOnClickListenerC5272b8 = c5279i.f14368b;
        if (viewOnClickListenerC5272b8 != null) {
            viewOnClickListenerC5272b8.setOnClickListener(onClickListener);
        }
        InterfaceC5280j interfaceC5280j = new InterfaceC5280j() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1.2
            @Override // p007b.p483p.p484a.InterfaceC5280j
            public final void onHide() {
                StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), NoticePopup$enqueue$notice$1.this.$noticeName, 0L, 2, null);
            }
        };
        C12238m.checkNotNullParameter(interfaceC5280j, "listener");
        ViewOnClickListenerC5272b viewOnClickListenerC5272b9 = c5279i.f14368b;
        if (viewOnClickListenerC5272b9 != null) {
            viewOnClickListenerC5272b9.setOnHideListener$alerter_release(interfaceC5280j);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b10 = c5279i.f14368b;
        final View layoutContainer = viewOnClickListenerC5272b10 != null ? viewOnClickListenerC5272b10.getLayoutContainer() : null;
        if (layoutContainer != null) {
            final ValueAnimator autoDismissAnimator = NoticePopup.INSTANCE.getAutoDismissAnimator(this.$noticeAutoDismissPeriodSecs, new NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$1(this, fragmentActivity));
            layoutContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$3$1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    C12238m.checkNotNullExpressionValue(motionEvent, "event");
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    NoticePopup.INSTANCE.cancelCountdown(autoDismissAnimator);
                    return false;
                }
            });
            int i2 = C5419R.id.popup_attachment;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) layoutContainer.findViewById(C5419R.id.popup_attachment);
            if (simpleDraweeView != null) {
                i2 = C5419R.id.popup_body;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) layoutContainer.findViewById(C5419R.id.popup_body);
                if (simpleDraweeSpanTextView != null) {
                    i2 = C5419R.id.popup_close_btn;
                    ImageView imageView = (ImageView) layoutContainer.findViewById(C5419R.id.popup_close_btn);
                    if (imageView != null) {
                        i2 = C5419R.id.popup_icon;
                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) layoutContainer.findViewById(C5419R.id.popup_icon);
                        if (simpleDraweeView2 != null) {
                            i2 = C5419R.id.popup_sticker;
                            StickerView stickerView = (StickerView) layoutContainer.findViewById(C5419R.id.popup_sticker);
                            if (stickerView != null) {
                                i2 = C5419R.id.popup_subtitle;
                                TextView textView = (TextView) layoutContainer.findViewById(C5419R.id.popup_subtitle);
                                if (textView != null) {
                                    i2 = C5419R.id.popup_title;
                                    TextView textView2 = (TextView) layoutContainer.findViewById(C5419R.id.popup_title);
                                    if (textView2 != null) {
                                        i2 = C5419R.id.popup_title_wrap;
                                        RelativeLayout relativeLayout = (RelativeLayout) layoutContainer.findViewById(C5419R.id.popup_title_wrap);
                                        if (relativeLayout != null) {
                                            final WidgetNoticePopupBinding widgetNoticePopupBinding = new WidgetNoticePopupBinding((RelativeLayout) layoutContainer, simpleDraweeView, simpleDraweeSpanTextView, imageView, simpleDraweeView2, stickerView, textView, textView2, relativeLayout);
                                            C12238m.checkNotNullExpressionValue(widgetNoticePopupBinding, "WidgetNoticePopupBinding.bind(view)");
                                            if (this.$noticeIconUrl != null) {
                                                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(simpleDraweeView2, this.$noticeIconUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeIconResId != null) {
                                                MGImages mGImages = MGImages.INSTANCE;
                                                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(mGImages, simpleDraweeView2, this.$noticeIconResId.intValue(), (MGImages.ChangeDetector) null, 4, (Object) null);
                                            }
                                            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setVisibility(this.$noticeBodyImageUrl != null || this.$noticeBodyImageDrawable != null ? 0 : 8);
                                            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setBackground(this.$noticeBodyBackgroundDrawable);
                                            if (this.$noticeBodyImageUrl != null) {
                                                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(simpleDraweeView, this.$noticeBodyImageUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeBodyImageDrawable != null) {
                                                MGImages mGImages2 = MGImages.INSTANCE;
                                                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(mGImages2, simpleDraweeView, this.$noticeBodyImageDrawable, (MGImages.ChangeDetector) null, 4, (Object) null);
                                            }
                                            C12238m.checkNotNullExpressionValue(textView2, "binding.popupTitle");
                                            textView2.setText(this.$noticeTitle);
                                            C12238m.checkNotNullExpressionValue(textView, "binding.popupSubtitle");
                                            ViewExtensions.setTextAndVisibilityBy(textView, this.$noticeSubtitle);
                                            CharSequence charSequence = this.$noticeBody;
                                            if (charSequence instanceof DraweeSpanStringBuilder) {
                                                simpleDraweeSpanTextView.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) charSequence);
                                            } else {
                                                C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                                simpleDraweeSpanTextView.setText(this.$noticeBody);
                                            }
                                            C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                            CharSequence charSequence2 = this.$noticeBody;
                                            simpleDraweeSpanTextView.setVisibility(charSequence2 != null && (C12103t.isBlank(charSequence2) ^ true) ? 0 : 8);
                                            simpleDraweeSpanTextView.post(new Runnable() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$3$2
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = widgetNoticePopupBinding.f17310c;
                                                    C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.popupBody");
                                                    Layout layout = simpleDraweeSpanTextView2.getLayout();
                                                    int lineCount = layout != null ? layout.getLineCount() : 0;
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = widgetNoticePopupBinding.f17310c;
                                                    C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.popupBody");
                                                    if (lineCount > simpleDraweeSpanTextView3.getMaxLines()) {
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = widgetNoticePopupBinding.f17310c;
                                                        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.popupBody");
                                                        Layout layout2 = simpleDraweeSpanTextView4.getLayout();
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView5 = widgetNoticePopupBinding.f17310c;
                                                        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView5, "binding.popupBody");
                                                        int lineEnd = layout2.getLineEnd(simpleDraweeSpanTextView5.getMaxLines() - 1);
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView6 = widgetNoticePopupBinding.f17310c;
                                                        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView6, "binding.popupBody");
                                                        CharSequence charSequenceSubSequence = simpleDraweeSpanTextView6.getText().subSequence(0, lineEnd - 1);
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView7 = widgetNoticePopupBinding.f17310c;
                                                        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView7, "binding.popupBody");
                                                        simpleDraweeSpanTextView7.setText(new SpannableStringBuilder(charSequenceSubSequence).append((CharSequence) "…"));
                                                    }
                                                }
                                            });
                                            Drawable drawable = this.$noticeIconTopRight;
                                            if (drawable == null) {
                                                drawable = ContextCompat.getDrawable(fragmentActivity, DrawableCompat.getThemedDrawableRes$default(fragmentActivity, C5419R.attr.ic_settings, 0, 2, (Object) null));
                                            }
                                            C12238m.checkNotNullExpressionValue(stickerView, "binding.popupSticker");
                                            List list = this.$noticeStickers;
                                            stickerView.setVisibility(list != null && !list.isEmpty() ? 0 : 8);
                                            List list2 = this.$noticeStickers;
                                            if (list2 == null || (sticker = (Sticker) C12163u.firstOrNull(list2)) == null) {
                                                view = null;
                                            } else {
                                                view = null;
                                                StickerView.m8613e(stickerView, sticker, null, 2);
                                            }
                                            imageView.setImageDrawable(drawable);
                                            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$2
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view2) {
                                                    NoticePopup.INSTANCE.dismiss(this.$noticeName);
                                                    this.$onClickTopRightIcon.invoke(layoutContainer);
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(layoutContainer.getResources().getResourceName(i2)));
        }
        view = null;
        WeakReference<ViewGroup> weakReference = C5279i.f14367a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC5278h(viewGroup, c5279i));
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b11 = c5279i.f14368b;
        View viewFindViewById = viewOnClickListenerC5272b11 != null ? viewOnClickListenerC5272b11.findViewById(C5419R.id.llAlertBackground) : view;
        if (viewFindViewById != null) {
            ViewCompat.setElevation(viewFindViewById, fragmentActivity.getResources().getDimension(C5419R.dimen.app_elevation));
        }
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }
}
