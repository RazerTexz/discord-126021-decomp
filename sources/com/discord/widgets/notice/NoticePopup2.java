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
import b.p.a.Alert;
import b.p.a.Alert2;
import b.p.a.Alerter;
import b.p.a.Alerter2;
import b.p.a.Alerter3;
import b.p.a.OnHideAlertListener;
import b.p.a.SwipeDismissTouchListener;
import com.discord.R;
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
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1, reason: use source file name */
/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup2 extends Lambda implements Function1<FragmentActivity, Boolean> {
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
    public NoticePopup2(Function1 function1, String str, Integer num, String str2, Integer num2, String str3, Drawable drawable, Drawable drawable2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Drawable drawable3, List list, Function1 function2) {
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
        Alert2 alert2;
        View view;
        ViewGroup viewGroup;
        Sticker sticker;
        Window window;
        int childCount;
        Alert2 alert3;
        Window window2;
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Alerter3 alerter3 = new Alerter3(null);
        View decorView = (fragmentActivity == null || (window2 = fragmentActivity.getWindow()) == null) ? null : window2.getDecorView();
        if (!(decorView instanceof ViewGroup)) {
            decorView = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) decorView;
        if (viewGroup2 != null && (childCount = viewGroup2.getChildCount()) >= 0) {
            int i = 0;
            while (true) {
                if (viewGroup2.getChildAt(i) instanceof Alert2) {
                    View childAt = viewGroup2.getChildAt(i);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                    alert3 = (Alert2) childAt;
                } else {
                    alert3 = null;
                }
                if (alert3 != null && alert3.getWindowToken() != null) {
                    ViewCompat.animate(alert3).alpha(0.0f).withEndAction(new Alerter(alert3));
                }
                if (i == childCount) {
                    break;
                }
                i++;
            }
        }
        if (fragmentActivity == null || (window = fragmentActivity.getWindow()) == null) {
            alert2 = null;
        } else {
            View decorView2 = window.getDecorView();
            Objects.requireNonNull(decorView2, "null cannot be cast to non-null type android.view.ViewGroup");
            Alerter3.a = new WeakReference<>((ViewGroup) decorView2);
            View decorView3 = window.getDecorView();
            Intrinsics3.checkNotNullExpressionValue(decorView3, "it.decorView");
            Context context = decorView3.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.decorView.context");
            alert2 = new Alert2(context, R.layout.widget_notice_popup, null, 0, 12);
        }
        alerter3.f1973b = alert2;
        int themedColor = ColorCompat.getThemedColor(fragmentActivity, R.attr.colorBackgroundTertiary);
        Alert2 alert4 = alerter3.f1973b;
        if (alert4 != null) {
            alert4.setAlertBackgroundColor(themedColor);
        }
        Alert2 alert5 = alerter3.f1973b;
        if (alert5 != null) {
            LinearLayout linearLayout = (LinearLayout) alert5.c(com.tapadoo.alerter.R.d.llAlertBackground);
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "it");
            linearLayout.setOnTouchListener(new SwipeDismissTouchListener(linearLayout, new Alert(alert5)));
        }
        Alert2 alert6 = alerter3.f1973b;
        if (alert6 != null) {
            alert6.setVibrationEnabled(false);
        }
        Alert2 alert7 = alerter3.f1973b;
        if (alert7 != null) {
            alert7.setEnableInfiniteDuration(true);
        }
        Alert2 alert8 = alerter3.f1973b;
        if (alert8 != null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(alert8.getContext(), R.anim.anim_slide_in_down);
            Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…lert?.context, animation)");
            alert8.setEnterAnimation$alerter_release(animationLoadAnimation);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Function1 function1 = NoticePopup2.this.$onClick;
                Intrinsics3.checkNotNullExpressionValue(view2, "view");
                function1.invoke(view2);
                NoticePopup.INSTANCE.dismiss(NoticePopup2.this.$noticeName);
            }
        };
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        Alert2 alert9 = alerter3.f1973b;
        if (alert9 != null) {
            alert9.setOnClickListener(onClickListener);
        }
        OnHideAlertListener onHideAlertListener = new OnHideAlertListener() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1.2
            @Override // b.p.a.OnHideAlertListener
            public final void onHide() {
                StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), NoticePopup2.this.$noticeName, 0L, 2, null);
            }
        };
        Intrinsics3.checkNotNullParameter(onHideAlertListener, "listener");
        Alert2 alert10 = alerter3.f1973b;
        if (alert10 != null) {
            alert10.setOnHideListener$alerter_release(onHideAlertListener);
        }
        Alert2 alert11 = alerter3.f1973b;
        final View layoutContainer = alert11 != null ? alert11.getLayoutContainer() : null;
        if (layoutContainer != null) {
            final ValueAnimator autoDismissAnimator = NoticePopup.INSTANCE.getAutoDismissAnimator(this.$noticeAutoDismissPeriodSecs, new NoticePopup3(this, fragmentActivity));
            layoutContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$3$1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    Intrinsics3.checkNotNullExpressionValue(motionEvent, "event");
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    NoticePopup.INSTANCE.cancelCountdown(autoDismissAnimator);
                    return false;
                }
            });
            int i2 = R.id.popup_attachment;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) layoutContainer.findViewById(R.id.popup_attachment);
            if (simpleDraweeView != null) {
                i2 = R.id.popup_body;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) layoutContainer.findViewById(R.id.popup_body);
                if (simpleDraweeSpanTextView != null) {
                    i2 = R.id.popup_close_btn;
                    ImageView imageView = (ImageView) layoutContainer.findViewById(R.id.popup_close_btn);
                    if (imageView != null) {
                        i2 = R.id.popup_icon;
                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) layoutContainer.findViewById(R.id.popup_icon);
                        if (simpleDraweeView2 != null) {
                            i2 = R.id.popup_sticker;
                            StickerView stickerView = (StickerView) layoutContainer.findViewById(R.id.popup_sticker);
                            if (stickerView != null) {
                                i2 = R.id.popup_subtitle;
                                TextView textView = (TextView) layoutContainer.findViewById(R.id.popup_subtitle);
                                if (textView != null) {
                                    i2 = R.id.popup_title;
                                    TextView textView2 = (TextView) layoutContainer.findViewById(R.id.popup_title);
                                    if (textView2 != null) {
                                        i2 = R.id.popup_title_wrap;
                                        RelativeLayout relativeLayout = (RelativeLayout) layoutContainer.findViewById(R.id.popup_title_wrap);
                                        if (relativeLayout != null) {
                                            final WidgetNoticePopupBinding widgetNoticePopupBinding = new WidgetNoticePopupBinding((RelativeLayout) layoutContainer, simpleDraweeView, simpleDraweeSpanTextView, imageView, simpleDraweeView2, stickerView, textView, textView2, relativeLayout);
                                            Intrinsics3.checkNotNullExpressionValue(widgetNoticePopupBinding, "WidgetNoticePopupBinding.bind(view)");
                                            if (this.$noticeIconUrl != null) {
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(simpleDraweeView2, this.$noticeIconUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeIconResId != null) {
                                                MGImages mGImages = MGImages.INSTANCE;
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(mGImages, simpleDraweeView2, this.$noticeIconResId.intValue(), (MGImages.ChangeDetector) null, 4, (Object) null);
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setVisibility(this.$noticeBodyImageUrl != null || this.$noticeBodyImageDrawable != null ? 0 : 8);
                                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setBackground(this.$noticeBodyBackgroundDrawable);
                                            if (this.$noticeBodyImageUrl != null) {
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(simpleDraweeView, this.$noticeBodyImageUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeBodyImageDrawable != null) {
                                                MGImages mGImages2 = MGImages.INSTANCE;
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(mGImages2, simpleDraweeView, this.$noticeBodyImageDrawable, (MGImages.ChangeDetector) null, 4, (Object) null);
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.popupTitle");
                                            textView2.setText(this.$noticeTitle);
                                            Intrinsics3.checkNotNullExpressionValue(textView, "binding.popupSubtitle");
                                            ViewExtensions.setTextAndVisibilityBy(textView, this.$noticeSubtitle);
                                            CharSequence charSequence = this.$noticeBody;
                                            if (charSequence instanceof DraweeSpanStringBuilder) {
                                                simpleDraweeSpanTextView.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) charSequence);
                                            } else {
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                                simpleDraweeSpanTextView.setText(this.$noticeBody);
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                            CharSequence charSequence2 = this.$noticeBody;
                                            simpleDraweeSpanTextView.setVisibility(charSequence2 != null && (StringsJVM.isBlank(charSequence2) ^ true) ? 0 : 8);
                                            simpleDraweeSpanTextView.post(new Runnable() { // from class: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$3$2
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = widgetNoticePopupBinding.c;
                                                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.popupBody");
                                                    Layout layout = simpleDraweeSpanTextView2.getLayout();
                                                    int lineCount = layout != null ? layout.getLineCount() : 0;
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = widgetNoticePopupBinding.c;
                                                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.popupBody");
                                                    if (lineCount > simpleDraweeSpanTextView3.getMaxLines()) {
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = widgetNoticePopupBinding.c;
                                                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.popupBody");
                                                        Layout layout2 = simpleDraweeSpanTextView4.getLayout();
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView5 = widgetNoticePopupBinding.c;
                                                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView5, "binding.popupBody");
                                                        int lineEnd = layout2.getLineEnd(simpleDraweeSpanTextView5.getMaxLines() - 1);
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView6 = widgetNoticePopupBinding.c;
                                                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView6, "binding.popupBody");
                                                        CharSequence charSequenceSubSequence = simpleDraweeSpanTextView6.getText().subSequence(0, lineEnd - 1);
                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView7 = widgetNoticePopupBinding.c;
                                                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView7, "binding.popupBody");
                                                        simpleDraweeSpanTextView7.setText(new SpannableStringBuilder(charSequenceSubSequence).append((CharSequence) "…"));
                                                    }
                                                }
                                            });
                                            Drawable drawable = this.$noticeIconTopRight;
                                            if (drawable == null) {
                                                drawable = ContextCompat.getDrawable(fragmentActivity, DrawableCompat.getThemedDrawableRes$default(fragmentActivity, R.attr.ic_settings, 0, 2, (Object) null));
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(stickerView, "binding.popupSticker");
                                            List list = this.$noticeStickers;
                                            stickerView.setVisibility(list != null && !list.isEmpty() ? 0 : 8);
                                            List list2 = this.$noticeStickers;
                                            if (list2 == null || (sticker = (Sticker) _Collections.firstOrNull(list2)) == null) {
                                                view = null;
                                            } else {
                                                view = null;
                                                StickerView.e(stickerView, sticker, null, 2);
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
        WeakReference<ViewGroup> weakReference = Alerter3.a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            new Handler(Looper.getMainLooper()).post(new Alerter2(viewGroup, alerter3));
        }
        Alert2 alert12 = alerter3.f1973b;
        View viewFindViewById = alert12 != null ? alert12.findViewById(R.id.llAlertBackground) : view;
        if (viewFindViewById != null) {
            ViewCompat.setElevation(viewFindViewById, fragmentActivity.getResources().getDimension(R.dimen.app_elevation));
        }
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }
}
