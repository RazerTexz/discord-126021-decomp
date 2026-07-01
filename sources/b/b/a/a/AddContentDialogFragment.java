package b.b.a.a;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import b.b.a.FlexInputCoordinator;
import b.b.a.d.AddContentPagerAdapter4;
import com.discord.utilities.color.ColorCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: b.b.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class AddContentDialogFragment extends AppCompatDialogFragment {
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
    public ViewPager.OnPageChangeListener onPageChangeListener;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final c itemSelectionListener = new c();

    /* JADX INFO: renamed from: b.b.a.a.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                AddContentDialogFragment addContentDialogFragment = (AddContentDialogFragment) this.k;
                int i2 = AddContentDialogFragment.j;
                if (addContentDialogFragment.isCancelable()) {
                    addContentDialogFragment.h(true);
                    return;
                }
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    throw null;
                }
                FlexInputFragment flexInputFragment = (FlexInputFragment) ((Fragment) this.k);
                FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onSendButtonClicked(flexInputFragment.inputListener);
                    return;
                }
                return;
            }
            AddContentDialogFragment addContentDialogFragment2 = (AddContentDialogFragment) this.k;
            Objects.requireNonNull(addContentDialogFragment2);
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            try {
                addContentDialogFragment2.startActivityForResult(intent, 5968);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(addContentDialogFragment2.getContext(), addContentDialogFragment2.getString(R.h.error_generic_title), 0).show();
            }
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.a$b */
    /* JADX INFO: compiled from: AddContentDialogFragment.kt */
    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ boolean k;

        public b(boolean z2) {
            this.k = z2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Function1<? super View, Unit> function1;
            Intrinsics3.checkNotNullParameter(animation, "animation");
            AddContentDialogFragment.this.dismissAllowingStateLoss();
            if (!this.k || (view = AddContentDialogFragment.this.getView()) == null || (function1 = AddContentDialogFragment.this.onKeyboardSelectedListener) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            function1.invoke(view);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics3.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics3.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.a$c */
    /* JADX INFO: compiled from: AddContentDialogFragment.kt */
    public static final class c implements SelectionCoordinator.ItemSelectionListener<Attachment<?>> {
        public c() {
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemSelected(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "item");
            AddContentDialogFragment.g(AddContentDialogFragment.this);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemUnselected(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "item");
            AddContentDialogFragment.g(AddContentDialogFragment.this);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void unregister() {
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.a$d */
    /* JADX INFO: compiled from: AddContentDialogFragment.kt */
    public static final class d extends AppCompatDialog {
        public d(AddContentDialogFragment addContentDialogFragment, Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void show() {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.a$e */
    /* JADX INFO: compiled from: AddContentDialogFragment.kt */
    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Fragment $flexInputFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.$flexInputFragment = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            TabLayout tabLayout;
            TabLayout.Tab tabAt;
            FragmentManager childFragmentManager = AddContentDialogFragment.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            AddContentPagerAdapter4.a[] aVarArrK = ((FlexInputFragment) this.$flexInputFragment).k();
            AddContentPagerAdapter4 addContentPagerAdapter4 = new AddContentPagerAdapter4(childFragmentManager, (AddContentPagerAdapter4.a[]) Arrays.copyOf(aVarArrK, aVarArrK.length));
            AddContentDialogFragment addContentDialogFragment = AddContentDialogFragment.this;
            Objects.requireNonNull(addContentDialogFragment);
            Intrinsics3.checkNotNullParameter(addContentPagerAdapter4, "pagerAdapter");
            Context context = addContentDialogFragment.getContext();
            if (context != null && (tabLayout = addContentDialogFragment.contentTabs) != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                Intrinsics3.checkNotNullParameter(context, "context");
                Intrinsics3.checkNotNullParameter(tabLayout, "tabLayout");
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context, R.c.tab_color_selector);
                int tabCount = tabLayout.getTabCount();
                for (int i = 0; i < tabCount; i++) {
                    TabLayout.Tab tabAt2 = tabLayout.getTabAt(i);
                    if (tabAt2 != null) {
                        Intrinsics3.checkNotNullExpressionValue(colorStateList, "iconColors");
                        Drawable icon = tabAt2.getIcon();
                        if (icon != null) {
                            Drawable drawableWrap = DrawableCompat.wrap(icon);
                            DrawableCompat.setTintList(drawableWrap, colorStateList);
                            tabAt2.setIcon(drawableWrap);
                        }
                    }
                }
                AddContentPagerAdapter4.a[] aVarArr = addContentPagerAdapter4.a;
                ArrayList arrayList = new ArrayList(aVarArr.length);
                for (AddContentPagerAdapter4.a aVar : aVarArr) {
                    TabLayout.Tab icon2 = tabLayout.newTab().setIcon(aVar.getIcon());
                    Intrinsics3.checkNotNullExpressionValue(icon2, "tabLayout.newTab()\n              .setIcon(it.icon)");
                    Intrinsics3.checkNotNullExpressionValue(colorStateList, "iconColors");
                    Drawable icon3 = icon2.getIcon();
                    if (icon3 != null) {
                        Drawable drawableWrap2 = DrawableCompat.wrap(icon3);
                        DrawableCompat.setTintList(drawableWrap2, colorStateList);
                        icon2.setIcon(drawableWrap2);
                    }
                    arrayList.add(icon2.setContentDescription(aVar.getContentDesc()));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    tabLayout.addTab((TabLayout.Tab) it.next());
                }
                ViewPager viewPager = addContentDialogFragment.contentPager;
                if (viewPager != null) {
                    viewPager.setAdapter(addContentPagerAdapter4);
                }
                TabLayout tabLayout2 = addContentDialogFragment.contentTabs;
                if (tabLayout2 != null) {
                    tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new AddContentDialogFragment2(addContentDialogFragment));
                }
                ViewPager viewPager2 = addContentDialogFragment.contentPager;
                if (viewPager2 != null) {
                    viewPager2.addOnPageChangeListener(new AddContentDialogFragment3(addContentDialogFragment));
                }
                TabLayout tabLayout3 = addContentDialogFragment.contentTabs;
                if (tabLayout3 != null && (tabAt = tabLayout3.getTabAt(0)) != null) {
                    tabAt.select();
                }
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.a$f */
    /* JADX INFO: compiled from: AddContentDialogFragment.kt */
    public static final class f extends AccessibilityDelegateCompat {
        public f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Intrinsics3.checkNotNullParameter(view, "host");
            Intrinsics3.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
            ImageView imageView = AddContentDialogFragment.this.launchButton;
            Objects.requireNonNull(imageView, "null cannot be cast to non-null type android.view.View");
            accessibilityNodeInfoCompat.setTraversalAfter(imageView);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.a$g */
    /* JADX INFO: compiled from: AddContentDialogFragment.kt */
    public static final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AddContentDialogFragment.g(AddContentDialogFragment.this);
        }
    }

    public static final void g(AddContentDialogFragment addContentDialogFragment) {
        FloatingActionButton floatingActionButton = addContentDialogFragment.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.post(new AddContentDialogFragment4(addContentDialogFragment));
        }
    }

    public final void h(boolean openKeyboard) {
        Context context = getContext();
        if (context == null) {
            dismissAllowingStateLoss();
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(context, "context ?: return dismissAllowingStateLoss()");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, com.google.android.material.R.anim.design_bottom_sheet_slide_out);
        Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "animation");
        animationLoadAnimation.setDuration(getResources().getInteger(com.google.android.material.R.integer.bottom_sheet_slide_duration));
        animationLoadAnimation.setInterpolator(context, android.R.anim.accelerate_decelerate_interpolator);
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
        animationLoadAnimation.setAnimationListener(new b(openKeyboard));
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
        FlexInputCoordinator flexInputCoordinator = (FlexInputCoordinator) parentFragment;
        if (clipData == null) {
            Uri data = intentData.getData();
            if (data != null) {
                flexInputCoordinator.f(Attachment.INSTANCE.b(data, contentResolver));
                return;
            }
            return;
        }
        Ranges2 ranges2Until = _Ranges.until(0, clipData.getItemCount());
        ArrayList<Uri> arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it = ranges2Until.iterator();
        while (it.hasNext()) {
            ClipData.Item itemAt = clipData.getItemAt(((Iterators4) it).nextInt());
            Intrinsics3.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(it)");
            arrayList.add(itemAt.getUri());
        }
        for (Uri uri : arrayList) {
            Attachment.Companion companion = Attachment.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(uri, "it");
            flexInputCoordinator.f(companion.b(uri, contentResolver));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @SuppressLint({"PrivateResource"})
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        d dVar = new d(this, getContext(), R.i.FlexInput_DialogWhenLarge);
        dVar.supportRequestWindowFeature(1);
        Window window = dVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(com.google.android.material.R.style.Animation_AppCompat_Dialog);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        return dVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.g.dialog_add_content_pager_with_fab, container, false);
        if (viewInflate != null) {
            viewInflate.setOnClickListener(new a(0, this));
            this.contentPager = (ViewPager) viewInflate.findViewById(R.f.content_pager);
            this.contentTabs = (TabLayout) viewInflate.findViewById(R.f.content_tabs);
            this.actionButton = (FloatingActionButton) viewInflate.findViewById(R.f.action_btn);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.f.launch_btn);
            this.launchButton = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new a(1, this));
            }
            FloatingActionButton floatingActionButton = this.actionButton;
            Objects.requireNonNull(floatingActionButton, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(viewInflate.getContext(), R.b.color_brand_500)));
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof FlexInputFragment) {
            FlexInputFragment flexInputFragment = (FlexInputFragment) parentFragment;
            e eVar = new e(parentFragment);
            Objects.requireNonNull(flexInputFragment);
            Intrinsics3.checkNotNullParameter(eVar, "onContentPagesInitialized");
            try {
                flexInputFragment.k();
                eVar.invoke();
            } catch (UninitializedPropertyAccessException unused) {
                flexInputFragment.onContentPagesInitializedUpdates.add(eVar);
            }
            FloatingActionButton floatingActionButton2 = this.actionButton;
            if (floatingActionButton2 != null) {
                floatingActionButton2.setOnClickListener(new a(2, parentFragment));
            }
            this.selectionAggregator = flexInputFragment.b().addItemSelectionListener(this.itemSelectionListener);
            FloatingActionButton floatingActionButton3 = this.actionButton;
            Objects.requireNonNull(floatingActionButton3, "null cannot be cast to non-null type android.view.View");
            ViewCompat.setAccessibilityDelegate(floatingActionButton3, new f());
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
            floatingActionButton.post(new g());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, com.google.android.material.R.anim.design_bottom_sheet_slide_in);
            Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "animation");
            animationLoadAnimation.setDuration(getResources().getInteger(com.google.android.material.R.integer.bottom_sheet_slide_duration));
            animationLoadAnimation.setInterpolator(context, android.R.anim.accelerate_decelerate_interpolator);
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
        Intrinsics3.checkNotNullParameter(transaction, "transaction");
        transaction.setCustomAnimations(com.google.android.material.R.anim.abc_grow_fade_in_from_bottom, com.google.android.material.R.anim.abc_shrink_fade_out_from_bottom);
        return super.show(transaction, tag);
    }
}
