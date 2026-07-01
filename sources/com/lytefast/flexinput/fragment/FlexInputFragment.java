package com.lytefast.flexinput.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import b.b.a.a.f;
import b.b.a.a.g;
import b.b.a.a.h;
import b.b.a.a.i;
import b.b.a.a.n;
import b.b.a.a.o;
import b.b.a.a.p;
import b.b.a.b;
import b.b.a.c;
import b.b.a.d.d$a;
import b.d.b.a.a;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.R$b;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.R$h;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FlexInputFragment extends Fragment implements b<Object> {
    public static final /* synthetic */ KProperty[] j = {a.d0(FlexInputFragment.class, "binding", "getBinding()Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0)};
    public static final String k = FlexInputFragment.class.getName();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public FlexEditText inputEt;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public b.b.a.f.a keyboardManager;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public FlexInputListener inputListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public FileManager fileManager;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter;
    public d$a[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public FlexInputViewModel viewModel;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public Subscription stateSubscription;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public Subscription eventSubscription;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public Subscription showExpressionKeyboardSubscription;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding = FragmentViewBindingDelegateKt.viewBinding$default(this, FlexInputFragment$c.j, null, 2, null);

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final List<Function0<Unit>> onViewCreatedUpdates = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public List<Function0<Unit>> onContentPagesInitializedUpdates = new ArrayList();

    public static final void g(FlexInputFragment flexInputFragment, int i) {
        ViewPager viewPager;
        FragmentTransaction fragmentTransactionBeginTransaction = flexInputFragment.getChildFragmentManager().beginTransaction();
        m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        b.b.a.a.a aVar = new b.b.a.a.a();
        aVar.show(fragmentTransactionBeginTransaction, "Add Content");
        flexInputFragment.getChildFragmentManager().executePendingTransactions();
        if (aVar.getDialog() == null) {
            return;
        }
        ViewPager viewPager2 = aVar.contentPager;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(i);
        }
        FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onContentDialogPageChanged(i);
        }
        f fVar = new f(flexInputFragment);
        m.checkNotNullParameter(fVar, "listener");
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = aVar.onPageChangeListener;
        if (viewPager$OnPageChangeListener != null && (viewPager = aVar.contentPager) != null) {
            viewPager.removeOnPageChangeListener(viewPager$OnPageChangeListener);
        }
        aVar.onPageChangeListener = fVar;
        ViewPager viewPager3 = aVar.contentPager;
        if (viewPager3 != null) {
            viewPager3.addOnPageChangeListener(fVar);
        }
        Dialog dialog = aVar.getDialog();
        if (dialog != null) {
            dialog.setOnDismissListener(new g(flexInputFragment));
        }
        h hVar = new h(flexInputFragment);
        m.checkNotNullParameter(hVar, "onKeyboardSelectedListener");
        aVar.onKeyboardSelectedListener = hVar;
    }

    public static final void h(FlexInputFragment flexInputFragment, boolean z2) {
        Object obj;
        Fragment fragmentFindFragmentById = flexInputFragment.getChildFragmentManager().findFragmentById(R$f.expression_tray_container);
        if (fragmentFindFragmentById != null && fragmentFindFragmentById.isAdded() && fragmentFindFragmentById.isResumed()) {
            if (!(fragmentFindFragmentById instanceof c)) {
                obj = fragmentFindFragmentById;
                obj = null;
            }
            obj = fragmentFindFragmentById;
            c cVar = (c) obj;
            if (cVar != null) {
                cVar.isShown(z2);
            }
        }
    }

    @Override // b.b.a.b
    public SelectionAggregator<Attachment<Object>> b() {
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = this.attachmentPreviewAdapter;
        if (attachmentPreviewAdapter == null) {
            m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
        }
        return attachmentPreviewAdapter.selectionAggregator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.a.b
    public void f(Attachment<? extends Object> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        DialogFragment dialogFragment = (DialogFragment) getChildFragmentManager().findFragmentByTag("Add Content");
        SelectionCoordinator<T, ?> selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        b().registerSelectionCoordinator(selectionCoordinator);
        selectionCoordinator.c(attachment, 0);
        selectionCoordinator.itemSelectionListener.unregister();
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onAttachmentsUpdated(b().getAttachments());
        }
        j().d.post(new FlexInputFragment$b(dialogFragment));
    }

    @Override // b.b.a.b
    public FileManager getFileManager() {
        FileManager fileManager = this.fileManager;
        if (fileManager == null) {
            m.throwUninitializedPropertyAccessException("fileManager");
        }
        return fileManager;
    }

    @Override // b.b.a.b
    public boolean hasMediaPermissions() {
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            return flexInputViewModel.hasMediaPermissions();
        }
        return false;
    }

    public final void i(Function0<Unit> onViewCreatedUpdate) {
        m.checkNotNullParameter(onViewCreatedUpdate, "onViewCreatedUpdate");
        try {
            LinearLayout linearLayout = j().f;
            onViewCreatedUpdate.invoke();
        } catch (IllegalStateException unused) {
            this.onViewCreatedUpdates.add(onViewCreatedUpdate);
        }
    }

    public final b.b.a.e.a j() {
        return (b.b.a.e.a) this.binding.getValue((Fragment) this, j[0]);
    }

    public final d$a[] k() {
        d$a[] d_aArr = this.r;
        if (d_aArr == null) {
            m.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        if (d_aArr.length == 0) {
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            m.checkNotNullParameter(contextRequireContext, "context");
            return new d$a[]{new b.b.a.d.a(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R$b.ic_flex_input_image, 0, 2, (Object) null), R$h.attachment_media), new b.b.a.d.b(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R$b.ic_flex_input_file, 0, 2, (Object) null), R$h.attachment_files), new b.b.a.d.c(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R$b.ic_flex_input_add_a_photo, 0, 2, (Object) null), R$h.camera)};
        }
        d$a[] d_aArr2 = this.r;
        if (d_aArr2 == null) {
            m.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        return d_aArr2;
    }

    public final FlexEditText l() {
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        return flexEditText;
    }

    public final boolean m() {
        View view;
        if (!isAdded() || isHidden() || (view = getView()) == null) {
            return false;
        }
        return view.getVisibility() == 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$g.flex_input_widget, container, false);
        View viewFindViewById = viewInflate.findViewById(R$f.text_input);
        m.checkNotNullExpressionValue(viewFindViewById, "root.findViewById(R.id.text_input)");
        this.inputEt = (FlexEditText) viewFindViewById;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TextWatcher.Companion.reset(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onFlexInputFragmentPause();
        }
        Subscription subscription = this.stateSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.eventSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        Subscription subscription3 = this.showExpressionKeyboardSubscription;
        if (subscription3 != null) {
            subscription3.unsubscribe();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            this.stateSubscription = flexInputViewModel.observeState().r().V(new n(new FlexInputFragment$d(this)));
            FlexInputViewModel flexInputViewModel2 = this.viewModel;
            if (flexInputViewModel2 != null) {
                this.eventSubscription = flexInputViewModel2.observeEvents().V(new n(new FlexInputFragment$e(this)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        m.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("FlexInput.ATTACHMENTS", b().getAttachments());
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        outState.putString("FlexInput.TEXT", String.valueOf(flexEditText.getText()));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FlexInputViewModel flexInputViewModel;
        m.checkNotNullParameter(view, "view");
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = new AttachmentPreviewAdapter<>(false, null, null, 7);
        attachmentPreviewAdapter.selectionAggregator.addItemSelectionListener(new b.b.a.a.m(this));
        this.attachmentPreviewAdapter = attachmentPreviewAdapter;
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        TextWatcherKt.addBindedTextWatcher(flexEditText, this, new FlexInputFragment$f(this));
        FlexEditText flexEditText2 = this.inputEt;
        if (flexEditText2 == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        flexEditText2.setOnClickListener(new FlexInputFragment$a(0, this));
        j().f322b.setOnClickListener(new FlexInputFragment$a(1, this));
        b.b.a.e.a aVarJ = j();
        j().i.setOnClickListener(new defpackage.h(0, this));
        j().o.setOnClickListener(new defpackage.h(1, this));
        aVarJ.l.setOnClickListener(new defpackage.h(2, this));
        aVarJ.m.setOnClickListener(new defpackage.h(3, this));
        aVarJ.h.setOnClickListener(new defpackage.h(4, this));
        AppCompatImageButton appCompatImageButton = aVarJ.f322b;
        m.checkNotNullExpressionValue(appCompatImageButton, "attachmentClearBtn");
        AppCompatImageButton appCompatImageButton2 = aVarJ.l;
        m.checkNotNullExpressionValue(appCompatImageButton2, "galleryBtn");
        AppCompatImageButton appCompatImageButton3 = aVarJ.m;
        m.checkNotNullExpressionValue(appCompatImageButton3, "giftBtn");
        AppCompatImageButton appCompatImageButton4 = aVarJ.i;
        m.checkNotNullExpressionValue(appCompatImageButton4, "expressionBtn");
        FrameLayout frameLayout = aVarJ.o;
        m.checkNotNullExpressionValue(frameLayout, "sendBtnContainer");
        AppCompatImageButton appCompatImageButton5 = aVarJ.h;
        m.checkNotNullExpressionValue(appCompatImageButton5, "expandBtn");
        Iterator it = d0.t.n.listOf((Object[]) new View[]{appCompatImageButton, appCompatImageButton2, appCompatImageButton3, appCompatImageButton4, frameLayout, appCompatImageButton5}).iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnLongClickListener(new i(this));
        }
        FrameLayout frameLayout2 = j().k;
        m.checkNotNullExpressionValue(frameLayout2, "binding.expressionTrayContainer");
        ViewGroup$LayoutParams layoutParams = frameLayout2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams) layoutParams;
        FrameLayout frameLayout3 = j().k;
        m.checkNotNullExpressionValue(frameLayout3, "binding.expressionTrayContainer");
        Context context = frameLayout3.getContext();
        m.checkNotNullExpressionValue(context, "binding.expressionTrayContainer.context");
        linearLayout$LayoutParams.height = (int) (DisplayUtils.getScreenSize(context).height() * 0.5f);
        FrameLayout frameLayout4 = j().k;
        m.checkNotNullExpressionValue(frameLayout4, "binding.expressionTrayContainer");
        frameLayout4.setLayoutParams(linearLayout$LayoutParams);
        if (savedInstanceState != null) {
            ArrayList<? super Parcelable> parcelableArrayList = savedInstanceState.getParcelableArrayList("FlexInput.ATTACHMENTS");
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                b().initFrom(parcelableArrayList);
            }
            FlexInputViewModel flexInputViewModel2 = this.viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(b().getAttachments());
            }
            String string = savedInstanceState.getString("FlexInput.TEXT");
            if (string != null && (flexInputViewModel = this.viewModel) != null) {
                flexInputViewModel.onInputTextChanged(string, null);
            }
        }
        FrameLayout frameLayout5 = j().k;
        m.checkNotNullExpressionValue(frameLayout5, "binding.expressionTrayContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout5);
        ViewCompat.setOnApplyWindowInsetsListener(j().g, o.a);
        ViewCompat.setOnApplyWindowInsetsListener(j().f, new p(this));
        Iterator<Function0<Unit>> it2 = this.onViewCreatedUpdates.iterator();
        while (it2.hasNext()) {
            it2.next().invoke();
        }
        this.onViewCreatedUpdates.clear();
    }

    @Override // b.b.a.b
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.requestMediaPermissions(onSuccess);
        }
    }
}
