package com.lytefast.flexinput.fragment;

import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewpager.widget.ViewPager;
import b.b.a.a.a;
import b.b.a.a.j;
import b.b.a.a.l;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.g0.w;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class FlexInputFragment$d extends k implements Function1<FlexInputState, Unit> {
    public FlexInputFragment$d(FlexInputFragment flexInputFragment) {
        super(1, flexInputFragment, FlexInputFragment.class, "configureUI", "configureUI(Lcom/lytefast/flexinput/viewmodel/FlexInputState;)V", 0);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(FlexInputState flexInputState) {
        boolean z2;
        FlexInputState flexInputState2 = flexInputState;
        m.checkNotNullParameter(flexInputState2, "p1");
        FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
        KProperty[] kPropertyArr = FlexInputFragment.j;
        Objects.requireNonNull(flexInputFragment);
        j jVar = new j(flexInputFragment);
        b.b.a.a.k kVar = new b.b.a.a.k(flexInputFragment);
        l lVar = new l(flexInputFragment);
        if (flexInputFragment.m()) {
            FlexEditText flexEditText = flexInputFragment.inputEt;
            if (flexEditText == null) {
                m.throwUninitializedPropertyAccessException("inputEt");
            }
            if (!m.areEqual(flexEditText.getEditableText().toString(), flexInputState2.inputText)) {
                FlexEditText flexEditText2 = flexInputFragment.inputEt;
                if (flexEditText2 == null) {
                    m.throwUninitializedPropertyAccessException("inputEt");
                }
                flexEditText2.setText(flexInputState2.inputText);
                FlexEditText flexEditText3 = flexInputFragment.inputEt;
                if (flexEditText3 == null) {
                    m.throwUninitializedPropertyAccessException("inputEt");
                }
                flexEditText3.setSelection(flexInputState2.inputText.length());
            }
            boolean z3 = flexInputState2.showExpandedButtons;
            AppCompatImageButton appCompatImageButton = flexInputFragment.j().h;
            m.checkNotNullExpressionValue(appCompatImageButton, "binding.expandBtn");
            appCompatImageButton.setVisibility(!z3 ? 0 : 8);
            AppCompatImageButton appCompatImageButton2 = flexInputFragment.j().m;
            m.checkNotNullExpressionValue(appCompatImageButton2, "binding.giftBtn");
            appCompatImageButton2.setVisibility(z3 ? 0 : 8);
            AppCompatImageButton appCompatImageButton3 = flexInputFragment.j().l;
            m.checkNotNullExpressionValue(appCompatImageButton3, "binding.galleryBtn");
            appCompatImageButton3.setVisibility(z3 ? 0 : 8);
            if (flexInputState2.ableToSendMessages) {
                String str = flexInputState2.inputText;
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                if ((w.trim(str).toString().length() > 0) || flexInputState2.attachments.size() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            ImageView imageView = flexInputFragment.j().p;
            m.checkNotNullExpressionValue(imageView, "binding.sendBtnImage");
            imageView.setEnabled(z2);
            FrameLayout frameLayout = flexInputFragment.j().o;
            m.checkNotNullExpressionValue(frameLayout, "binding.sendBtnContainer");
            frameLayout.setEnabled(z2);
            boolean z4 = (flexInputState2.inputText.length() > 0) || flexInputState2.attachments.size() > 0;
            FrameLayout frameLayout2 = flexInputFragment.j().o;
            m.checkNotNullExpressionValue(frameLayout2, "binding.sendBtnContainer");
            frameLayout2.setVisibility(z4 ? 0 : 8);
            LinearLayout linearLayout = flexInputFragment.j().n;
            m.checkNotNullExpressionValue(linearLayout, "binding.mainInputContainer");
            ViewGroup$LayoutParams layoutParams = linearLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout$LayoutParams relativeLayout$LayoutParams = (RelativeLayout$LayoutParams) layoutParams;
            relativeLayout$LayoutParams.rightMargin = !z4 ? DimenUtils.dpToPixels(8) : 0;
            LinearLayout linearLayout2 = flexInputFragment.j().n;
            m.checkNotNullExpressionValue(linearLayout2, "binding.mainInputContainer");
            linearLayout2.setLayoutParams(relativeLayout$LayoutParams);
            if (flexInputState2.attachments.isEmpty()) {
                AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragment.attachmentPreviewAdapter;
                if (attachmentPreviewAdapter == null) {
                    m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
                }
                attachmentPreviewAdapter.selectionAggregator.clear();
                attachmentPreviewAdapter.notifyDataSetChanged();
            }
            LinearLayout linearLayout3 = flexInputFragment.j().c;
            m.checkNotNullExpressionValue(linearLayout3, "binding.attachmentPreviewContainer");
            linearLayout3.setVisibility((flexInputState2.attachments.size() > 0 && flexInputState2.ableToSendMessages && flexInputState2.attachmentViewEnabled) ? 0 : 8);
            AppCompatImageButton appCompatImageButton4 = flexInputFragment.j().l;
            m.checkNotNullExpressionValue(appCompatImageButton4, "binding.galleryBtn");
            ViewExtensions.setEnabledAlpha$default(appCompatImageButton4, flexInputState2.ableToSendMessages && flexInputState2.ableToAttachFiles, 0.0f, 2, null);
            a aVar = (a) flexInputFragment.getChildFragmentManager().findFragmentByTag("Add Content");
            Integer num = flexInputState2.showContentDialogIndex;
            if (num != null) {
                if (aVar == null) {
                    try {
                        FlexInputFragment.g(jVar.this$0, num.intValue());
                    } catch (Exception e) {
                        Log.d(FlexInputFragment.k, "Could not open AddContentDialogFragment", e);
                    }
                } else {
                    int iIntValue = num.intValue();
                    ViewPager viewPager = aVar.contentPager;
                    if (viewPager != null) {
                        viewPager.setCurrentItem(iIntValue);
                    }
                }
            } else if (aVar != null && aVar.isAdded() && !aVar.isDetached()) {
                aVar.dismissAllowingStateLoss();
            }
            TextView textView = flexInputFragment.j().e;
            m.checkNotNullExpressionValue(textView, "binding.cannotSendText");
            textView.setVisibility(flexInputState2.ableToSendMessages ? 8 : 0);
            if (flexInputState2.showExpressionTray) {
                lVar.invoke2();
            } else {
                kVar.invoke(flexInputState2.showExpressionTrayButtonBadge);
            }
        }
        return Unit.a;
    }
}
