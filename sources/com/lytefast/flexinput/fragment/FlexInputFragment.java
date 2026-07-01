package com.lytefast.flexinput.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import b.b.a.FlexInputCoordinator;
import b.b.a.FlexInputExpressionTrayStateChangeListener;
import b.b.a.a.AddContentDialogFragment;
import b.b.a.a.g;
import b.b.a.a.h;
import b.b.a.a.i;
import b.b.a.a.j;
import b.b.a.a.k;
import b.b.a.a.l;
import b.b.a.a.m;
import b.b.a.a.n;
import b.b.a.a.o;
import b.b.a.a.p;
import b.b.a.d.AddContentPagerAdapter;
import b.b.a.d.AddContentPagerAdapter2;
import b.b.a.d.AddContentPagerAdapter3;
import b.b.a.d.AddContentPagerAdapter4;
import b.b.a.e.FlexInputWidgetBinding;
import b.b.a.f.KeyboardManager;
import b.b.a.h.FlexInputEvent;
import b.d.b.a.outline;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FlexInputFragment extends Fragment implements FlexInputCoordinator<Object> {
    public static final /* synthetic */ KProperty[] j = {outline.d0(FlexInputFragment.class, "binding", "getBinding()Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0)};
    public static final String k = FlexInputFragment.class.getName();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public FlexEditText inputEt;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public KeyboardManager keyboardManager;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public FlexInputListener inputListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public FileManager fileManager;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter;
    public AddContentPagerAdapter4.a[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public FlexInputViewModel viewModel;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public Subscription stateSubscription;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public Subscription eventSubscription;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public Subscription showExpressionKeyboardSubscription;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final List<Function0<Unit>> onViewCreatedUpdates = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public List<Function0<Unit>> onContentPagesInitializedUpdates = new ArrayList();

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
                FlexInputViewModel flexInputViewModel = ((FlexInputFragment) this.k).viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onInputTextClicked();
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = ((FlexInputFragment) this.k).attachmentPreviewAdapter;
            if (attachmentPreviewAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
            }
            attachmentPreviewAdapter.selectionAggregator.clear();
            attachmentPreviewAdapter.notifyDataSetChanged();
            FlexInputViewModel flexInputViewModel2 = ((FlexInputFragment) this.k).viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(Collections2.emptyList());
            }
        }
    }

    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final class b implements Runnable {
        public final /* synthetic */ DialogFragment j;

        public b(DialogFragment dialogFragment) {
            this.j = dialogFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DialogFragment dialogFragment = this.j;
            if (dialogFragment == null || !dialogFragment.isAdded() || this.j.isRemoving() || this.j.isDetached()) {
                return;
            }
            try {
                this.j.dismiss();
            } catch (IllegalStateException e) {
                Log.w(FlexInputFragment.k, "could not dismiss add content dialog", e);
            }
        }
    }

    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, FlexInputWidgetBinding> {
        public static final c j = new c();

        public c() {
            super(1, FlexInputWidgetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public FlexInputWidgetBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.f.attachment_clear_btn;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view2.findViewById(i);
            if (appCompatImageButton != null) {
                i = R.f.attachment_preview_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
                if (linearLayout != null) {
                    i = R.f.attachment_preview_list;
                    RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                    if (recyclerView != null) {
                        i = R.f.cannot_send_text;
                        TextView textView = (TextView) view2.findViewById(i);
                        if (textView != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view2;
                            i = R.f.default_window_insets_handler;
                            FrameLayout frameLayout = (FrameLayout) view2.findViewById(i);
                            if (frameLayout != null) {
                                i = R.f.expand_btn;
                                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) view2.findViewById(i);
                                if (appCompatImageButton2 != null) {
                                    i = R.f.expression_btn;
                                    AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) view2.findViewById(i);
                                    if (appCompatImageButton3 != null) {
                                        i = R.f.expression_btn_badge;
                                        ImageView imageView = (ImageView) view2.findViewById(i);
                                        if (imageView != null) {
                                            i = R.f.expression_btn_container;
                                            FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(i);
                                            if (frameLayout2 != null) {
                                                i = R.f.expression_tray_container;
                                                FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(i);
                                                if (frameLayout3 != null) {
                                                    i = R.f.gallery_btn;
                                                    AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) view2.findViewById(i);
                                                    if (appCompatImageButton4 != null) {
                                                        i = R.f.gift_btn;
                                                        AppCompatImageButton appCompatImageButton5 = (AppCompatImageButton) view2.findViewById(i);
                                                        if (appCompatImageButton5 != null) {
                                                            i = R.f.left_btns_container;
                                                            LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(i);
                                                            if (linearLayout3 != null) {
                                                                i = R.f.main_input_container;
                                                                LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(i);
                                                                if (linearLayout4 != null) {
                                                                    i = R.f.send_btn_container;
                                                                    FrameLayout frameLayout4 = (FrameLayout) view2.findViewById(i);
                                                                    if (frameLayout4 != null) {
                                                                        i = R.f.send_btn_image;
                                                                        ImageView imageView2 = (ImageView) view2.findViewById(i);
                                                                        if (imageView2 != null) {
                                                                            i = R.f.text_input;
                                                                            FlexEditText flexEditText = (FlexEditText) view2.findViewById(i);
                                                                            if (flexEditText != null) {
                                                                                return new FlexInputWidgetBinding(linearLayout2, appCompatImageButton, linearLayout, recyclerView, textView, linearLayout2, frameLayout, appCompatImageButton2, appCompatImageButton3, imageView, frameLayout2, frameLayout3, appCompatImageButton4, appCompatImageButton5, linearLayout3, linearLayout4, frameLayout4, imageView2, flexEditText);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements Function1<FlexInputState, Unit> {
        public d(FlexInputFragment flexInputFragment) {
            super(1, flexInputFragment, FlexInputFragment.class, "configureUI", "configureUI(Lcom/lytefast/flexinput/viewmodel/FlexInputState;)V", 0);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(FlexInputState flexInputState) {
            boolean z2;
            FlexInputState flexInputState2 = flexInputState;
            Intrinsics3.checkNotNullParameter(flexInputState2, "p1");
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
            KProperty[] kPropertyArr = FlexInputFragment.j;
            Objects.requireNonNull(flexInputFragment);
            j jVar = new j(flexInputFragment);
            k kVar = new k(flexInputFragment);
            l lVar = new l(flexInputFragment);
            if (flexInputFragment.m()) {
                FlexEditText flexEditText = flexInputFragment.inputEt;
                if (flexEditText == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
                }
                if (!Intrinsics3.areEqual(flexEditText.getEditableText().toString(), flexInputState2.inputText)) {
                    FlexEditText flexEditText2 = flexInputFragment.inputEt;
                    if (flexEditText2 == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
                    }
                    flexEditText2.setText(flexInputState2.inputText);
                    FlexEditText flexEditText3 = flexInputFragment.inputEt;
                    if (flexEditText3 == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
                    }
                    flexEditText3.setSelection(flexInputState2.inputText.length());
                }
                boolean z3 = flexInputState2.showExpandedButtons;
                AppCompatImageButton appCompatImageButton = flexInputFragment.j().h;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageButton, "binding.expandBtn");
                appCompatImageButton.setVisibility(!z3 ? 0 : 8);
                AppCompatImageButton appCompatImageButton2 = flexInputFragment.j().m;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageButton2, "binding.giftBtn");
                appCompatImageButton2.setVisibility(z3 ? 0 : 8);
                AppCompatImageButton appCompatImageButton3 = flexInputFragment.j().l;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageButton3, "binding.galleryBtn");
                appCompatImageButton3.setVisibility(z3 ? 0 : 8);
                if (flexInputState2.ableToSendMessages) {
                    String str = flexInputState2.inputText;
                    Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                    if ((Strings4.trim(str).toString().length() > 0) || flexInputState2.attachments.size() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                ImageView imageView = flexInputFragment.j().p;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.sendBtnImage");
                imageView.setEnabled(z2);
                FrameLayout frameLayout = flexInputFragment.j().o;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.sendBtnContainer");
                frameLayout.setEnabled(z2);
                boolean z4 = (flexInputState2.inputText.length() > 0) || flexInputState2.attachments.size() > 0;
                FrameLayout frameLayout2 = flexInputFragment.j().o;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.sendBtnContainer");
                frameLayout2.setVisibility(z4 ? 0 : 8);
                LinearLayout linearLayout = flexInputFragment.j().n;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mainInputContainer");
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.rightMargin = !z4 ? DimenUtils.dpToPixels(8) : 0;
                LinearLayout linearLayout2 = flexInputFragment.j().n;
                Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.mainInputContainer");
                linearLayout2.setLayoutParams(layoutParams2);
                if (flexInputState2.attachments.isEmpty()) {
                    AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragment.attachmentPreviewAdapter;
                    if (attachmentPreviewAdapter == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
                    }
                    attachmentPreviewAdapter.selectionAggregator.clear();
                    attachmentPreviewAdapter.notifyDataSetChanged();
                }
                LinearLayout linearLayout3 = flexInputFragment.j().c;
                Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.attachmentPreviewContainer");
                linearLayout3.setVisibility((flexInputState2.attachments.size() > 0 && flexInputState2.ableToSendMessages && flexInputState2.attachmentViewEnabled) ? 0 : 8);
                AppCompatImageButton appCompatImageButton4 = flexInputFragment.j().l;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageButton4, "binding.galleryBtn");
                ViewExtensions.setEnabledAlpha$default(appCompatImageButton4, flexInputState2.ableToSendMessages && flexInputState2.ableToAttachFiles, 0.0f, 2, null);
                AddContentDialogFragment addContentDialogFragment = (AddContentDialogFragment) flexInputFragment.getChildFragmentManager().findFragmentByTag("Add Content");
                Integer num = flexInputState2.showContentDialogIndex;
                if (num != null) {
                    if (addContentDialogFragment == null) {
                        try {
                            FlexInputFragment.g(jVar.this$0, num.intValue());
                        } catch (Exception e) {
                            Log.d(FlexInputFragment.k, "Could not open AddContentDialogFragment", e);
                        }
                    } else {
                        int iIntValue = num.intValue();
                        ViewPager viewPager = addContentDialogFragment.contentPager;
                        if (viewPager != null) {
                            viewPager.setCurrentItem(iIntValue);
                        }
                    }
                } else if (addContentDialogFragment != null && addContentDialogFragment.isAdded() && !addContentDialogFragment.isDetached()) {
                    addContentDialogFragment.dismissAllowingStateLoss();
                }
                TextView textView = flexInputFragment.j().e;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.cannotSendText");
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

    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class e extends FunctionReferenceImpl implements Function1<FlexInputEvent, Unit> {
        public e(FlexInputFragment flexInputFragment) {
            super(1, flexInputFragment, FlexInputFragment.class, "handleEvent", "handleEvent(Lcom/lytefast/flexinput/viewmodel/FlexInputEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(FlexInputEvent flexInputEvent) {
            FlexInputEvent flexInputEvent2 = flexInputEvent;
            Intrinsics3.checkNotNullParameter(flexInputEvent2, "p1");
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
            KProperty[] kPropertyArr = FlexInputFragment.j;
            Objects.requireNonNull(flexInputFragment);
            if (flexInputEvent2 instanceof FlexInputEvent.d) {
                Toast.makeText(flexInputFragment.requireContext(), ((FlexInputEvent.d) flexInputEvent2).a, 0).show();
            } else if (flexInputEvent2 instanceof FlexInputEvent.e) {
                Toast.makeText(flexInputFragment.requireContext(), ((FlexInputEvent.e) flexInputEvent2).a, 0).show();
            } else if (flexInputEvent2 instanceof FlexInputEvent.c) {
                KeyboardManager keyboardManager = flexInputFragment.keyboardManager;
                if (keyboardManager != null) {
                    FlexEditText flexEditText = flexInputFragment.inputEt;
                    if (flexEditText == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
                    }
                    keyboardManager.requestDisplay(flexEditText);
                }
            } else if (flexInputEvent2 instanceof FlexInputEvent.b) {
                KeyboardManager keyboardManager2 = flexInputFragment.keyboardManager;
                if (keyboardManager2 != null) {
                    keyboardManager2.requestHide();
                }
            } else if (flexInputEvent2 instanceof FlexInputEvent.a) {
                flexInputFragment.j().q.performClick();
            }
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final class f extends Lambda implements Function1<Editable, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Editable editable2 = editable;
            Intrinsics3.checkNotNullParameter(editable2, "it");
            FlexInputViewModel flexInputViewModel = FlexInputFragment.this.viewModel;
            if (flexInputViewModel != null) {
                b.i.a.f.e.o.f.P0(flexInputViewModel, editable2.toString(), null, 2, null);
            }
            return Unit.a;
        }
    }

    public static final void g(FlexInputFragment flexInputFragment, int i) {
        ViewPager viewPager;
        FragmentTransaction fragmentTransactionBeginTransaction = flexInputFragment.getChildFragmentManager().beginTransaction();
        Intrinsics3.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        AddContentDialogFragment addContentDialogFragment = new AddContentDialogFragment();
        addContentDialogFragment.show(fragmentTransactionBeginTransaction, "Add Content");
        flexInputFragment.getChildFragmentManager().executePendingTransactions();
        if (addContentDialogFragment.getDialog() == null) {
            return;
        }
        ViewPager viewPager2 = addContentDialogFragment.contentPager;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(i);
        }
        FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onContentDialogPageChanged(i);
        }
        b.b.a.a.f fVar = new b.b.a.a.f(flexInputFragment);
        Intrinsics3.checkNotNullParameter(fVar, "listener");
        ViewPager.OnPageChangeListener onPageChangeListener = addContentDialogFragment.onPageChangeListener;
        if (onPageChangeListener != null && (viewPager = addContentDialogFragment.contentPager) != null) {
            viewPager.removeOnPageChangeListener(onPageChangeListener);
        }
        addContentDialogFragment.onPageChangeListener = fVar;
        ViewPager viewPager3 = addContentDialogFragment.contentPager;
        if (viewPager3 != null) {
            viewPager3.addOnPageChangeListener(fVar);
        }
        Dialog dialog = addContentDialogFragment.getDialog();
        if (dialog != null) {
            dialog.setOnDismissListener(new g(flexInputFragment));
        }
        h hVar = new h(flexInputFragment);
        Intrinsics3.checkNotNullParameter(hVar, "onKeyboardSelectedListener");
        addContentDialogFragment.onKeyboardSelectedListener = hVar;
    }

    public static final void h(FlexInputFragment flexInputFragment, boolean z2) {
        Object obj;
        Fragment fragmentFindFragmentById = flexInputFragment.getChildFragmentManager().findFragmentById(R.f.expression_tray_container);
        if (fragmentFindFragmentById != null && fragmentFindFragmentById.isAdded() && fragmentFindFragmentById.isResumed()) {
            if (!(fragmentFindFragmentById instanceof FlexInputExpressionTrayStateChangeListener)) {
                obj = fragmentFindFragmentById;
                obj = null;
            }
            obj = fragmentFindFragmentById;
            FlexInputExpressionTrayStateChangeListener flexInputExpressionTrayStateChangeListener = (FlexInputExpressionTrayStateChangeListener) obj;
            if (flexInputExpressionTrayStateChangeListener != null) {
                flexInputExpressionTrayStateChangeListener.isShown(z2);
            }
        }
    }

    @Override // b.b.a.FlexInputCoordinator
    public SelectionAggregator<Attachment<Object>> b() {
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = this.attachmentPreviewAdapter;
        if (attachmentPreviewAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
        }
        return attachmentPreviewAdapter.selectionAggregator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.a.FlexInputCoordinator
    public void f(Attachment<? extends Object> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        DialogFragment dialogFragment = (DialogFragment) getChildFragmentManager().findFragmentByTag("Add Content");
        SelectionCoordinator<T, ?> selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        b().registerSelectionCoordinator(selectionCoordinator);
        selectionCoordinator.c(attachment, 0);
        selectionCoordinator.itemSelectionListener.unregister();
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onAttachmentsUpdated(b().getAttachments());
        }
        j().d.post(new b(dialogFragment));
    }

    @Override // b.b.a.FlexInputCoordinator
    public FileManager getFileManager() {
        FileManager fileManager = this.fileManager;
        if (fileManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fileManager");
        }
        return fileManager;
    }

    @Override // b.b.a.FlexInputCoordinator
    public boolean hasMediaPermissions() {
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            return flexInputViewModel.hasMediaPermissions();
        }
        return false;
    }

    public final void i(Function0<Unit> onViewCreatedUpdate) {
        Intrinsics3.checkNotNullParameter(onViewCreatedUpdate, "onViewCreatedUpdate");
        try {
            LinearLayout linearLayout = j().f;
            onViewCreatedUpdate.invoke();
        } catch (IllegalStateException unused) {
            this.onViewCreatedUpdates.add(onViewCreatedUpdate);
        }
    }

    public final FlexInputWidgetBinding j() {
        return (FlexInputWidgetBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    public final AddContentPagerAdapter4.a[] k() {
        AddContentPagerAdapter4.a[] aVarArr = this.r;
        if (aVarArr == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        if (aVarArr.length == 0) {
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
            return new AddContentPagerAdapter4.a[]{new AddContentPagerAdapter(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.b.ic_flex_input_image, 0, 2, (Object) null), R.h.attachment_media), new AddContentPagerAdapter2(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.b.ic_flex_input_file, 0, 2, (Object) null), R.h.attachment_files), new AddContentPagerAdapter3(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.b.ic_flex_input_add_a_photo, 0, 2, (Object) null), R.h.camera)};
        }
        AddContentPagerAdapter4.a[] aVarArr2 = this.r;
        if (aVarArr2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        return aVarArr2;
    }

    public final FlexEditText l() {
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
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
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.g.flex_input_widget, container, false);
        View viewFindViewById = viewInflate.findViewById(R.f.text_input);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "root.findViewById(R.id.text_input)");
        this.inputEt = (FlexEditText) viewFindViewById;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TextWatcher.INSTANCE.reset(this);
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
            this.stateSubscription = flexInputViewModel.observeState().r().V(new n(new d(this)));
            FlexInputViewModel flexInputViewModel2 = this.viewModel;
            if (flexInputViewModel2 != null) {
                this.eventSubscription = flexInputViewModel2.observeEvents().V(new n(new e(this)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics3.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("FlexInput.ATTACHMENTS", b().getAttachments());
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
        }
        outState.putString("FlexInput.TEXT", String.valueOf(flexEditText.getText()));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FlexInputViewModel flexInputViewModel;
        Intrinsics3.checkNotNullParameter(view, "view");
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = new AttachmentPreviewAdapter<>(false, null, null, 7);
        attachmentPreviewAdapter.selectionAggregator.addItemSelectionListener(new m(this));
        this.attachmentPreviewAdapter = attachmentPreviewAdapter;
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
        }
        TextWatcher4.addBindedTextWatcher(flexEditText, this, new f());
        FlexEditText flexEditText2 = this.inputEt;
        if (flexEditText2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputEt");
        }
        flexEditText2.setOnClickListener(new a(0, this));
        j().f322b.setOnClickListener(new a(1, this));
        FlexInputWidgetBinding flexInputWidgetBindingJ = j();
        j().i.setOnClickListener(new defpackage.h(0, this));
        j().o.setOnClickListener(new defpackage.h(1, this));
        flexInputWidgetBindingJ.l.setOnClickListener(new defpackage.h(2, this));
        flexInputWidgetBindingJ.m.setOnClickListener(new defpackage.h(3, this));
        flexInputWidgetBindingJ.h.setOnClickListener(new defpackage.h(4, this));
        AppCompatImageButton appCompatImageButton = flexInputWidgetBindingJ.f322b;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageButton, "attachmentClearBtn");
        AppCompatImageButton appCompatImageButton2 = flexInputWidgetBindingJ.l;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageButton2, "galleryBtn");
        AppCompatImageButton appCompatImageButton3 = flexInputWidgetBindingJ.m;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageButton3, "giftBtn");
        AppCompatImageButton appCompatImageButton4 = flexInputWidgetBindingJ.i;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageButton4, "expressionBtn");
        FrameLayout frameLayout = flexInputWidgetBindingJ.o;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "sendBtnContainer");
        AppCompatImageButton appCompatImageButton5 = flexInputWidgetBindingJ.h;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageButton5, "expandBtn");
        Iterator it = Collections2.listOf((Object[]) new View[]{appCompatImageButton, appCompatImageButton2, appCompatImageButton3, appCompatImageButton4, frameLayout, appCompatImageButton5}).iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnLongClickListener(new i(this));
        }
        FrameLayout frameLayout2 = j().k;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.expressionTrayContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        FrameLayout frameLayout3 = j().k;
        Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.expressionTrayContainer");
        Context context = frameLayout3.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.expressionTrayContainer.context");
        layoutParams2.height = (int) (DisplayUtils.getScreenSize(context).height() * 0.5f);
        FrameLayout frameLayout4 = j().k;
        Intrinsics3.checkNotNullExpressionValue(frameLayout4, "binding.expressionTrayContainer");
        frameLayout4.setLayoutParams(layoutParams2);
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
        Intrinsics3.checkNotNullExpressionValue(frameLayout5, "binding.expressionTrayContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout5);
        ViewCompat.setOnApplyWindowInsetsListener(j().g, o.a);
        ViewCompat.setOnApplyWindowInsetsListener(j().f, new p(this));
        Iterator<Function0<Unit>> it2 = this.onViewCreatedUpdates.iterator();
        while (it2.hasNext()) {
            it2.next().invoke();
        }
        this.onViewCreatedUpdates.clear();
    }

    @Override // b.b.a.FlexInputCoordinator
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.requestMediaPermissions(onSuccess);
        }
    }
}
