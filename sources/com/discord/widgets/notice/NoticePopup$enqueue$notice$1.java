package com.discord.widgets.notice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
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
import b.p.a.a;
import b.p.a.b;
import b.p.a.g;
import b.p.a.h;
import b.p.a.i;
import b.p.a.l;
import com.discord.R$anim;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetNoticePopupBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tapadoo.alerter.R$d;
import d0.g0.t;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1 extends o implements Function1<FragmentActivity, Boolean> {
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
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        b bVar;
        View view;
        ViewGroup viewGroup;
        Sticker sticker;
        Window window;
        int childCount;
        b bVar2;
        Window window2;
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        i iVar = new i(null);
        View decorView = (fragmentActivity == null || (window2 = fragmentActivity.getWindow()) == null) ? null : window2.getDecorView();
        if (!(decorView instanceof ViewGroup)) {
            decorView = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) decorView;
        if (viewGroup2 != null && (childCount = viewGroup2.getChildCount()) >= 0) {
            int i = 0;
            while (true) {
                if (viewGroup2.getChildAt(i) instanceof b) {
                    View childAt = viewGroup2.getChildAt(i);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                    bVar2 = (b) childAt;
                } else {
                    bVar2 = null;
                }
                if (bVar2 != null && bVar2.getWindowToken() != null) {
                    ViewCompat.animate(bVar2).alpha(0.0f).withEndAction(new g(bVar2));
                }
                if (i == childCount) {
                    break;
                }
                i++;
            }
        }
        if (fragmentActivity == null || (window = fragmentActivity.getWindow()) == null) {
            bVar = null;
        } else {
            View decorView2 = window.getDecorView();
            Objects.requireNonNull(decorView2, "null cannot be cast to non-null type android.view.ViewGroup");
            i.a = new WeakReference<>((ViewGroup) decorView2);
            View decorView3 = window.getDecorView();
            m.checkNotNullExpressionValue(decorView3, "it.decorView");
            Context context = decorView3.getContext();
            m.checkNotNullExpressionValue(context, "it.decorView.context");
            bVar = new b(context, R$layout.widget_notice_popup, null, 0, 12);
        }
        iVar.f1973b = bVar;
        int themedColor = ColorCompat.getThemedColor(fragmentActivity, 2130968914);
        b bVar3 = iVar.f1973b;
        if (bVar3 != null) {
            bVar3.setAlertBackgroundColor(themedColor);
        }
        b bVar4 = iVar.f1973b;
        if (bVar4 != null) {
            LinearLayout linearLayout = (LinearLayout) bVar4.c(R$d.llAlertBackground);
            m.checkNotNullExpressionValue(linearLayout, "it");
            linearLayout.setOnTouchListener(new l(linearLayout, new a(bVar4)));
        }
        b bVar5 = iVar.f1973b;
        if (bVar5 != null) {
            bVar5.setVibrationEnabled(false);
        }
        b bVar6 = iVar.f1973b;
        if (bVar6 != null) {
            bVar6.setEnableInfiniteDuration(true);
        }
        b bVar7 = iVar.f1973b;
        if (bVar7 != null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(bVar7.getContext(), R$anim.anim_slide_in_down);
            m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…lert?.context, animation)");
            bVar7.setEnterAnimation$alerter_release(animationLoadAnimation);
        }
        NoticePopup$enqueue$notice$1$1 noticePopup$enqueue$notice$1$1 = new NoticePopup$enqueue$notice$1$1(this);
        m.checkNotNullParameter(noticePopup$enqueue$notice$1$1, "onClickListener");
        b bVar8 = iVar.f1973b;
        if (bVar8 != null) {
            bVar8.setOnClickListener(noticePopup$enqueue$notice$1$1);
        }
        NoticePopup$enqueue$notice$1$2 noticePopup$enqueue$notice$1$2 = new NoticePopup$enqueue$notice$1$2(this);
        m.checkNotNullParameter(noticePopup$enqueue$notice$1$2, "listener");
        b bVar9 = iVar.f1973b;
        if (bVar9 != null) {
            bVar9.setOnHideListener$alerter_release(noticePopup$enqueue$notice$1$2);
        }
        b bVar10 = iVar.f1973b;
        View layoutContainer = bVar10 != null ? bVar10.getLayoutContainer() : null;
        if (layoutContainer != null) {
            layoutContainer.setOnTouchListener(new NoticePopup$enqueue$notice$1$3$1(NoticePopup.access$getAutoDismissAnimator(NoticePopup.INSTANCE, this.$noticeAutoDismissPeriodSecs, new NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$1(this, fragmentActivity))));
            int i2 = R$id.popup_attachment;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) layoutContainer.findViewById(R$id.popup_attachment);
            if (simpleDraweeView != null) {
                i2 = R$id.popup_body;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) layoutContainer.findViewById(R$id.popup_body);
                if (simpleDraweeSpanTextView != null) {
                    i2 = R$id.popup_close_btn;
                    ImageView imageView = (ImageView) layoutContainer.findViewById(R$id.popup_close_btn);
                    if (imageView != null) {
                        i2 = R$id.popup_icon;
                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) layoutContainer.findViewById(R$id.popup_icon);
                        if (simpleDraweeView2 != null) {
                            i2 = R$id.popup_sticker;
                            StickerView stickerView = (StickerView) layoutContainer.findViewById(R$id.popup_sticker);
                            if (stickerView != null) {
                                i2 = R$id.popup_subtitle;
                                TextView textView = (TextView) layoutContainer.findViewById(R$id.popup_subtitle);
                                if (textView != null) {
                                    i2 = R$id.popup_title;
                                    TextView textView2 = (TextView) layoutContainer.findViewById(R$id.popup_title);
                                    if (textView2 != null) {
                                        i2 = R$id.popup_title_wrap;
                                        RelativeLayout relativeLayout = (RelativeLayout) layoutContainer.findViewById(R$id.popup_title_wrap);
                                        if (relativeLayout != null) {
                                            WidgetNoticePopupBinding widgetNoticePopupBinding = new WidgetNoticePopupBinding((RelativeLayout) layoutContainer, simpleDraweeView, simpleDraweeSpanTextView, imageView, simpleDraweeView2, stickerView, textView, textView2, relativeLayout);
                                            m.checkNotNullExpressionValue(widgetNoticePopupBinding, "WidgetNoticePopupBinding.bind(view)");
                                            if (this.$noticeIconUrl != null) {
                                                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(simpleDraweeView2, this.$noticeIconUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeIconResId != null) {
                                                MGImages mGImages = MGImages.INSTANCE;
                                                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(mGImages, simpleDraweeView2, this.$noticeIconResId.intValue(), (MGImages$ChangeDetector) null, 4, (Object) null);
                                            }
                                            m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setVisibility(this.$noticeBodyImageUrl != null || this.$noticeBodyImageDrawable != null ? 0 : 8);
                                            m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setBackground(this.$noticeBodyBackgroundDrawable);
                                            if (this.$noticeBodyImageUrl != null) {
                                                m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(simpleDraweeView, this.$noticeBodyImageUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeBodyImageDrawable != null) {
                                                MGImages mGImages2 = MGImages.INSTANCE;
                                                m.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(mGImages2, simpleDraweeView, this.$noticeBodyImageDrawable, (MGImages$ChangeDetector) null, 4, (Object) null);
                                            }
                                            m.checkNotNullExpressionValue(textView2, "binding.popupTitle");
                                            textView2.setText(this.$noticeTitle);
                                            m.checkNotNullExpressionValue(textView, "binding.popupSubtitle");
                                            ViewExtensions.setTextAndVisibilityBy(textView, this.$noticeSubtitle);
                                            CharSequence charSequence = this.$noticeBody;
                                            if (charSequence instanceof DraweeSpanStringBuilder) {
                                                simpleDraweeSpanTextView.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) charSequence);
                                            } else {
                                                m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                                simpleDraweeSpanTextView.setText(this.$noticeBody);
                                            }
                                            m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                            CharSequence charSequence2 = this.$noticeBody;
                                            simpleDraweeSpanTextView.setVisibility(charSequence2 != null && (t.isBlank(charSequence2) ^ true) ? 0 : 8);
                                            simpleDraweeSpanTextView.post(new NoticePopup$enqueue$notice$1$3$2(widgetNoticePopupBinding));
                                            Drawable drawable = this.$noticeIconTopRight;
                                            if (drawable == null) {
                                                drawable = ContextCompat.getDrawable(fragmentActivity, DrawableCompat.getThemedDrawableRes$default(fragmentActivity, 2130969539, 0, 2, (Object) null));
                                            }
                                            m.checkNotNullExpressionValue(stickerView, "binding.popupSticker");
                                            List list = this.$noticeStickers;
                                            stickerView.setVisibility(list != null && !list.isEmpty() ? 0 : 8);
                                            List list2 = this.$noticeStickers;
                                            if (list2 == null || (sticker = (Sticker) u.firstOrNull(list2)) == null) {
                                                view = null;
                                            } else {
                                                view = null;
                                                StickerView.e(stickerView, sticker, null, 2);
                                            }
                                            imageView.setImageDrawable(drawable);
                                            imageView.setOnClickListener(new NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$2(layoutContainer, this, fragmentActivity));
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
        WeakReference<ViewGroup> weakReference = i.a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            new Handler(Looper.getMainLooper()).post(new h(viewGroup, iVar));
        }
        b bVar11 = iVar.f1973b;
        View viewFindViewById = bVar11 != null ? bVar11.findViewById(R$id.llAlertBackground) : view;
        if (viewFindViewById != null) {
            ViewCompat.setElevation(viewFindViewById, fragmentActivity.getResources().getDimension(2131165281));
        }
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }
}
