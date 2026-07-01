package b.b.a.a;

import android.R$color;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipData$Item;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.discord.utilities.color.ColorCompat;
import com.google.android.material.R$anim;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.lytefast.flexinput.R$b;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.R$i;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Attachment$Companion;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.t.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AppCompatDialogFragment {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public ViewPager contentPager;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public TabLayout contentTabs;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public FloatingActionButton actionButton;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public ImageView launchButton;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public SelectionAggregator<Attachment<Object>> selectionAggregator;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public Function1<? super View, Unit> onKeyboardSelectedListener;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public ViewPager$OnPageChangeListener onPageChangeListener;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final a$c itemSelectionListener = new a$c(this);

    public static final void g(a aVar) {
        FloatingActionButton floatingActionButton = aVar.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.post(new d(aVar));
        }
    }

    public final void h(boolean openKeyboard) {
        Context context = getContext();
        if (context == null) {
            dismissAllowingStateLoss();
            return;
        }
        d0.z.d.m.checkNotNullExpressionValue(context, "context ?: return dismissAllowingStateLoss()");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R$anim.design_bottom_sheet_slide_out);
        d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation, "animation");
        animationLoadAnimation.setDuration(getResources().getInteger(R$integer.bottom_sheet_slide_duration));
        animationLoadAnimation.setInterpolator(context, android.R$anim.accelerate_decelerate_interpolator);
        FloatingActionButton floatingActionButton = this.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.hide();
        }
        TabLayout tabLayout = this.contentTabs;
        if (tabLayout != null) {
            tabLayout.startAnimation(animationLoadAnimation);
        }
        ViewPager viewPager = this.contentPager;
        if (viewPager != null) {
            viewPager.startAnimation(animationLoadAnimation);
        }
        ImageView imageView = this.launchButton;
        if (imageView != null) {
            imageView.startAnimation(animationLoadAnimation);
        }
        animationLoadAnimation.setAnimationListener(new a$b(this, openKeyboard));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intentData) {
        ContentResolver contentResolver;
        super.onActivityResult(requestCode, resultCode, intentData);
        if (5968 != requestCode || resultCode == 0) {
            return;
        }
        if (-1 != resultCode || intentData == null) {
            Toast.makeText(getContext(), "Error loading files", 0).show();
            return;
        }
        Context context = getContext();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        ClipData clipData = intentData.getClipData();
        ActivityResultCaller parentFragment = getParentFragment();
        Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type com.lytefast.flexinput.FlexInputCoordinator<kotlin.Any>");
        b.b.a.b bVar = (b.b.a.b) parentFragment;
        if (clipData == null) {
            Uri data = intentData.getData();
            if (data != null) {
                bVar.f(Attachment.Companion.b(data, contentResolver));
                return;
            }
            return;
        }
        IntRange intRangeUntil = d0.d0.f.until(0, clipData.getItemCount());
        ArrayList<Uri> arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ClipData$Item itemAt = clipData.getItemAt(((c0) it).nextInt());
            d0.z.d.m.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(it)");
            arrayList.add(itemAt.getUri());
        }
        for (Uri uri : arrayList) {
            Attachment$Companion attachment$Companion = Attachment.Companion;
            d0.z.d.m.checkNotNullExpressionValue(uri, "it");
            bVar.f(attachment$Companion.b(uri, contentResolver));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @SuppressLint({"PrivateResource"})
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        a$d a_d = new a$d(this, getContext(), R$i.FlexInput_DialogWhenLarge);
        a_d.supportRequestWindowFeature(1);
        Window window = a_d.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.Animation_AppCompat_Dialog);
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        return a_d;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        d0.z.d.m.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$g.dialog_add_content_pager_with_fab, container, false);
        if (viewInflate != null) {
            viewInflate.setOnClickListener(new a$a(0, this));
            this.contentPager = (ViewPager) viewInflate.findViewById(R$f.content_pager);
            this.contentTabs = (TabLayout) viewInflate.findViewById(R$f.content_tabs);
            this.actionButton = (FloatingActionButton) viewInflate.findViewById(R$f.action_btn);
            ImageView imageView = (ImageView) viewInflate.findViewById(R$f.launch_btn);
            this.launchButton = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new a$a(1, this));
            }
            FloatingActionButton floatingActionButton = this.actionButton;
            Objects.requireNonNull(floatingActionButton, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(viewInflate.getContext(), R$b.color_brand_500)));
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof FlexInputFragment) {
            FlexInputFragment flexInputFragment = (FlexInputFragment) parentFragment;
            a$e a_e = new a$e(this, parentFragment);
            Objects.requireNonNull(flexInputFragment);
            d0.z.d.m.checkNotNullParameter(a_e, "onContentPagesInitialized");
            try {
                flexInputFragment.k();
                a_e.invoke();
            } catch (UninitializedPropertyAccessException unused) {
                flexInputFragment.onContentPagesInitializedUpdates.add(a_e);
            }
            FloatingActionButton floatingActionButton2 = this.actionButton;
            if (floatingActionButton2 != null) {
                floatingActionButton2.setOnClickListener(new a$a(2, parentFragment));
            }
            this.selectionAggregator = flexInputFragment.b().addItemSelectionListener(this.itemSelectionListener);
            FloatingActionButton floatingActionButton3 = this.actionButton;
            Objects.requireNonNull(floatingActionButton3, "null cannot be cast to non-null type android.view.View");
            ViewCompat.setAccessibilityDelegate(floatingActionButton3, new a$f(this));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionAggregator<Attachment<Object>> selectionAggregator = this.selectionAggregator;
        if (selectionAggregator != null) {
            selectionAggregator.removeItemSelectionListener(this.itemSelectionListener);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FloatingActionButton floatingActionButton = this.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.post(new a$g(this));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Context context = getContext();
        if (context != null) {
            d0.z.d.m.checkNotNullExpressionValue(context, "it");
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R$anim.design_bottom_sheet_slide_in);
            d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation, "animation");
            animationLoadAnimation.setDuration(getResources().getInteger(R$integer.bottom_sheet_slide_duration));
            animationLoadAnimation.setInterpolator(context, android.R$anim.accelerate_decelerate_interpolator);
            TabLayout tabLayout = this.contentTabs;
            if (tabLayout != null) {
                tabLayout.startAnimation(animationLoadAnimation);
            }
            ViewPager viewPager = this.contentPager;
            if (viewPager != null) {
                viewPager.startAnimation(animationLoadAnimation);
            }
            ImageView imageView = this.launchButton;
            if (imageView != null) {
                imageView.startAnimation(animationLoadAnimation);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @SuppressLint({"PrivateResource"})
    public int show(FragmentTransaction transaction, String tag) {
        d0.z.d.m.checkNotNullParameter(transaction, "transaction");
        transaction.setCustomAnimations(R$anim.abc_grow_fade_in_from_bottom, R$anim.abc_shrink_fade_out_from_bottom);
        return super.show(transaction, tag);
    }
}
