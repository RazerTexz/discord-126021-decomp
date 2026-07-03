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
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import com.lytefast.flexinput.widget.FlexEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p000.ViewOnClickListenerC12411h;
import p007b.p076b.p077a.InterfaceC1429b;
import p007b.p076b.p077a.InterfaceC1430c;
import p007b.p076b.p077a.p078a.C1413a;
import p007b.p076b.p077a.p078a.C1418f;
import p007b.p076b.p077a.p078a.C1420h;
import p007b.p076b.p077a.p078a.C1422j;
import p007b.p076b.p077a.p078a.C1423k;
import p007b.p076b.p077a.p078a.C1424l;
import p007b.p076b.p077a.p078a.C1425m;
import p007b.p076b.p077a.p078a.C1426n;
import p007b.p076b.p077a.p078a.C1427o;
import p007b.p076b.p077a.p078a.C1428p;
import p007b.p076b.p077a.p078a.DialogInterfaceOnDismissListenerC1419g;
import p007b.p076b.p077a.p078a.ViewOnLongClickListenerC1421i;
import p007b.p076b.p077a.p079d.C1431a;
import p007b.p076b.p077a.p079d.C1432b;
import p007b.p076b.p077a.p079d.C1433c;
import p007b.p076b.p077a.p079d.C1434d;
import p007b.p076b.p077a.p080e.C1444a;
import p007b.p076b.p077a.p081f.InterfaceC1447a;
import p007b.p076b.p077a.p083h.AbstractC1451a;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FlexInputFragment extends Fragment implements InterfaceC1429b<Object> {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f22054j = {C1643a.m846d0(FlexInputFragment.class, "binding", "getBinding()Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0)};

    /* JADX INFO: renamed from: k */
    public static final String f22055k = FlexInputFragment.class.getName();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public FlexEditText inputEt;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public InterfaceC1447a keyboardManager;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public FlexInputListener inputListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public FileManager fileManager;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter;

    /* JADX INFO: renamed from: r */
    public C1434d.a[] f22062r;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public FlexInputViewModel viewModel;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public Subscription stateSubscription;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public Subscription eventSubscription;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public Subscription showExpressionKeyboardSubscription;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding = FragmentViewBindingDelegateKt.viewBinding$default(this, C11183c.f22072j, null, 2, null);

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final List<Function0<Unit>> onViewCreatedUpdates = new ArrayList();

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public List<Function0<Unit>> onContentPagesInitializedUpdates = new ArrayList();

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FlexInputFragment$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes.dex */
    public static final class ViewOnClickListenerC11181a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f22069j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f22070k;

        public ViewOnClickListenerC11181a(int i, Object obj) {
            this.f22069j = i;
            this.f22070k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f22069j;
            if (i == 0) {
                FlexInputViewModel flexInputViewModel = ((FlexInputFragment) this.f22070k).viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onInputTextClicked();
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = ((FlexInputFragment) this.f22070k).attachmentPreviewAdapter;
            if (attachmentPreviewAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
            }
            attachmentPreviewAdapter.selectionAggregator.clear();
            attachmentPreviewAdapter.notifyDataSetChanged();
            FlexInputViewModel flexInputViewModel2 = ((FlexInputFragment) this.f22070k).viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(C12147n.emptyList());
            }
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FlexInputFragment$b */
    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final class RunnableC11182b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ DialogFragment f22071j;

        public RunnableC11182b(DialogFragment dialogFragment) {
            this.f22071j = dialogFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DialogFragment dialogFragment = this.f22071j;
            if (dialogFragment == null || !dialogFragment.isAdded() || this.f22071j.isRemoving() || this.f22071j.isDetached()) {
                return;
            }
            try {
                this.f22071j.dismiss();
            } catch (IllegalStateException e) {
                Log.w(FlexInputFragment.f22055k, "could not dismiss add content dialog", e);
            }
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FlexInputFragment$c */
    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class C11183c extends C12236k implements Function1<View, C1444a> {

        /* JADX INFO: renamed from: j */
        public static final C11183c f22072j = new C11183c();

        public C11183c() {
            super(1, C1444a.class, "bind", "bind(Landroid/view/View;)Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1444a invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C11170R.f.attachment_clear_btn;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view2.findViewById(i);
            if (appCompatImageButton != null) {
                i = C11170R.f.attachment_preview_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
                if (linearLayout != null) {
                    i = C11170R.f.attachment_preview_list;
                    RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                    if (recyclerView != null) {
                        i = C11170R.f.cannot_send_text;
                        TextView textView = (TextView) view2.findViewById(i);
                        if (textView != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view2;
                            i = C11170R.f.default_window_insets_handler;
                            FrameLayout frameLayout = (FrameLayout) view2.findViewById(i);
                            if (frameLayout != null) {
                                i = C11170R.f.expand_btn;
                                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) view2.findViewById(i);
                                if (appCompatImageButton2 != null) {
                                    i = C11170R.f.expression_btn;
                                    AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) view2.findViewById(i);
                                    if (appCompatImageButton3 != null) {
                                        i = C11170R.f.expression_btn_badge;
                                        ImageView imageView = (ImageView) view2.findViewById(i);
                                        if (imageView != null) {
                                            i = C11170R.f.expression_btn_container;
                                            FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(i);
                                            if (frameLayout2 != null) {
                                                i = C11170R.f.expression_tray_container;
                                                FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(i);
                                                if (frameLayout3 != null) {
                                                    i = C11170R.f.gallery_btn;
                                                    AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) view2.findViewById(i);
                                                    if (appCompatImageButton4 != null) {
                                                        i = C11170R.f.gift_btn;
                                                        AppCompatImageButton appCompatImageButton5 = (AppCompatImageButton) view2.findViewById(i);
                                                        if (appCompatImageButton5 != null) {
                                                            i = C11170R.f.left_btns_container;
                                                            LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(i);
                                                            if (linearLayout3 != null) {
                                                                i = C11170R.f.main_input_container;
                                                                LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(i);
                                                                if (linearLayout4 != null) {
                                                                    i = C11170R.f.send_btn_container;
                                                                    FrameLayout frameLayout4 = (FrameLayout) view2.findViewById(i);
                                                                    if (frameLayout4 != null) {
                                                                        i = C11170R.f.send_btn_image;
                                                                        ImageView imageView2 = (ImageView) view2.findViewById(i);
                                                                        if (imageView2 != null) {
                                                                            i = C11170R.f.text_input;
                                                                            FlexEditText flexEditText = (FlexEditText) view2.findViewById(i);
                                                                            if (flexEditText != null) {
                                                                                return new C1444a(linearLayout2, appCompatImageButton, linearLayout, recyclerView, textView, linearLayout2, frameLayout, appCompatImageButton2, appCompatImageButton3, imageView, frameLayout2, frameLayout3, appCompatImageButton4, appCompatImageButton5, linearLayout3, linearLayout4, frameLayout4, imageView2, flexEditText);
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

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FlexInputFragment$d */
    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class C11184d extends C12236k implements Function1<FlexInputState, Unit> {
        public C11184d(FlexInputFragment flexInputFragment) {
            super(1, flexInputFragment, FlexInputFragment.class, "configureUI", "configureUI(Lcom/lytefast/flexinput/viewmodel/FlexInputState;)V", 0);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(FlexInputState flexInputState) {
            boolean z2;
            FlexInputState flexInputState2 = flexInputState;
            C12238m.checkNotNullParameter(flexInputState2, "p1");
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
            KProperty[] kPropertyArr = FlexInputFragment.f22054j;
            Objects.requireNonNull(flexInputFragment);
            C1422j c1422j = new C1422j(flexInputFragment);
            C1423k c1423k = new C1423k(flexInputFragment);
            C1424l c1424l = new C1424l(flexInputFragment);
            if (flexInputFragment.m9294m()) {
                FlexEditText flexEditText = flexInputFragment.inputEt;
                if (flexEditText == null) {
                    C12238m.throwUninitializedPropertyAccessException("inputEt");
                }
                if (!C12238m.areEqual(flexEditText.getEditableText().toString(), flexInputState2.inputText)) {
                    FlexEditText flexEditText2 = flexInputFragment.inputEt;
                    if (flexEditText2 == null) {
                        C12238m.throwUninitializedPropertyAccessException("inputEt");
                    }
                    flexEditText2.setText(flexInputState2.inputText);
                    FlexEditText flexEditText3 = flexInputFragment.inputEt;
                    if (flexEditText3 == null) {
                        C12238m.throwUninitializedPropertyAccessException("inputEt");
                    }
                    flexEditText3.setSelection(flexInputState2.inputText.length());
                }
                boolean z3 = flexInputState2.showExpandedButtons;
                AppCompatImageButton appCompatImageButton = flexInputFragment.m9291j().f2179h;
                C12238m.checkNotNullExpressionValue(appCompatImageButton, "binding.expandBtn");
                appCompatImageButton.setVisibility(!z3 ? 0 : 8);
                AppCompatImageButton appCompatImageButton2 = flexInputFragment.m9291j().f2184m;
                C12238m.checkNotNullExpressionValue(appCompatImageButton2, "binding.giftBtn");
                appCompatImageButton2.setVisibility(z3 ? 0 : 8);
                AppCompatImageButton appCompatImageButton3 = flexInputFragment.m9291j().f2183l;
                C12238m.checkNotNullExpressionValue(appCompatImageButton3, "binding.galleryBtn");
                appCompatImageButton3.setVisibility(z3 ? 0 : 8);
                if (flexInputState2.ableToSendMessages) {
                    String str = flexInputState2.inputText;
                    Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                    if ((C12106w.trim(str).toString().length() > 0) || flexInputState2.attachments.size() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                ImageView imageView = flexInputFragment.m9291j().f2187p;
                C12238m.checkNotNullExpressionValue(imageView, "binding.sendBtnImage");
                imageView.setEnabled(z2);
                FrameLayout frameLayout = flexInputFragment.m9291j().f2186o;
                C12238m.checkNotNullExpressionValue(frameLayout, "binding.sendBtnContainer");
                frameLayout.setEnabled(z2);
                boolean z4 = (flexInputState2.inputText.length() > 0) || flexInputState2.attachments.size() > 0;
                FrameLayout frameLayout2 = flexInputFragment.m9291j().f2186o;
                C12238m.checkNotNullExpressionValue(frameLayout2, "binding.sendBtnContainer");
                frameLayout2.setVisibility(z4 ? 0 : 8);
                LinearLayout linearLayout = flexInputFragment.m9291j().f2185n;
                C12238m.checkNotNullExpressionValue(linearLayout, "binding.mainInputContainer");
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.rightMargin = !z4 ? DimenUtils.dpToPixels(8) : 0;
                LinearLayout linearLayout2 = flexInputFragment.m9291j().f2185n;
                C12238m.checkNotNullExpressionValue(linearLayout2, "binding.mainInputContainer");
                linearLayout2.setLayoutParams(layoutParams2);
                if (flexInputState2.attachments.isEmpty()) {
                    AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragment.attachmentPreviewAdapter;
                    if (attachmentPreviewAdapter == null) {
                        C12238m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
                    }
                    attachmentPreviewAdapter.selectionAggregator.clear();
                    attachmentPreviewAdapter.notifyDataSetChanged();
                }
                LinearLayout linearLayout3 = flexInputFragment.m9291j().f2174c;
                C12238m.checkNotNullExpressionValue(linearLayout3, "binding.attachmentPreviewContainer");
                linearLayout3.setVisibility((flexInputState2.attachments.size() > 0 && flexInputState2.ableToSendMessages && flexInputState2.attachmentViewEnabled) ? 0 : 8);
                AppCompatImageButton appCompatImageButton4 = flexInputFragment.m9291j().f2183l;
                C12238m.checkNotNullExpressionValue(appCompatImageButton4, "binding.galleryBtn");
                ViewExtensions.setEnabledAlpha$default(appCompatImageButton4, flexInputState2.ableToSendMessages && flexInputState2.ableToAttachFiles, 0.0f, 2, null);
                C1413a c1413a = (C1413a) flexInputFragment.getChildFragmentManager().findFragmentByTag("Add Content");
                Integer num = flexInputState2.showContentDialogIndex;
                if (num != null) {
                    if (c1413a == null) {
                        try {
                            FlexInputFragment.m9288g(c1422j.this$0, num.intValue());
                        } catch (Exception e) {
                            Log.d(FlexInputFragment.f22055k, "Could not open AddContentDialogFragment", e);
                        }
                    } else {
                        int iIntValue = num.intValue();
                        ViewPager viewPager = c1413a.contentPager;
                        if (viewPager != null) {
                            viewPager.setCurrentItem(iIntValue);
                        }
                    }
                } else if (c1413a != null && c1413a.isAdded() && !c1413a.isDetached()) {
                    c1413a.dismissAllowingStateLoss();
                }
                TextView textView = flexInputFragment.m9291j().f2176e;
                C12238m.checkNotNullExpressionValue(textView, "binding.cannotSendText");
                textView.setVisibility(flexInputState2.ableToSendMessages ? 8 : 0);
                if (flexInputState2.showExpressionTray) {
                    c1424l.invoke2();
                } else {
                    c1423k.invoke(flexInputState2.showExpressionTrayButtonBadge);
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FlexInputFragment$e */
    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class C11185e extends C12236k implements Function1<AbstractC1451a, Unit> {
        public C11185e(FlexInputFragment flexInputFragment) {
            super(1, flexInputFragment, FlexInputFragment.class, "handleEvent", "handleEvent(Lcom/lytefast/flexinput/viewmodel/FlexInputEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AbstractC1451a abstractC1451a) {
            AbstractC1451a abstractC1451a2 = abstractC1451a;
            C12238m.checkNotNullParameter(abstractC1451a2, "p1");
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
            KProperty[] kPropertyArr = FlexInputFragment.f22054j;
            Objects.requireNonNull(flexInputFragment);
            if (abstractC1451a2 instanceof AbstractC1451a.d) {
                Toast.makeText(flexInputFragment.requireContext(), ((AbstractC1451a.d) abstractC1451a2).f2205a, 0).show();
            } else if (abstractC1451a2 instanceof AbstractC1451a.e) {
                Toast.makeText(flexInputFragment.requireContext(), ((AbstractC1451a.e) abstractC1451a2).f2206a, 0).show();
            } else if (abstractC1451a2 instanceof AbstractC1451a.c) {
                InterfaceC1447a interfaceC1447a = flexInputFragment.keyboardManager;
                if (interfaceC1447a != null) {
                    FlexEditText flexEditText = flexInputFragment.inputEt;
                    if (flexEditText == null) {
                        C12238m.throwUninitializedPropertyAccessException("inputEt");
                    }
                    interfaceC1447a.requestDisplay(flexEditText);
                }
            } else if (abstractC1451a2 instanceof AbstractC1451a.b) {
                InterfaceC1447a interfaceC1447a2 = flexInputFragment.keyboardManager;
                if (interfaceC1447a2 != null) {
                    interfaceC1447a2.requestHide();
                }
            } else if (abstractC1451a2 instanceof AbstractC1451a.a) {
                flexInputFragment.m9291j().f2188q.performClick();
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.FlexInputFragment$f */
    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final class C11186f extends AbstractC12240o implements Function1<Editable, Unit> {
        public C11186f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Editable editable2 = editable;
            C12238m.checkNotNullParameter(editable2, "it");
            FlexInputViewModel flexInputViewModel = FlexInputFragment.this.viewModel;
            if (flexInputViewModel != null) {
                C3404f.m4235P0(flexInputViewModel, editable2.toString(), null, 2, null);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: g */
    public static final void m9288g(FlexInputFragment flexInputFragment, int i) {
        ViewPager viewPager;
        FragmentTransaction fragmentTransactionBeginTransaction = flexInputFragment.getChildFragmentManager().beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        C1413a c1413a = new C1413a();
        c1413a.show(fragmentTransactionBeginTransaction, "Add Content");
        flexInputFragment.getChildFragmentManager().executePendingTransactions();
        if (c1413a.getDialog() == null) {
            return;
        }
        ViewPager viewPager2 = c1413a.contentPager;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(i);
        }
        FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onContentDialogPageChanged(i);
        }
        C1418f c1418f = new C1418f(flexInputFragment);
        C12238m.checkNotNullParameter(c1418f, "listener");
        ViewPager.OnPageChangeListener onPageChangeListener = c1413a.onPageChangeListener;
        if (onPageChangeListener != null && (viewPager = c1413a.contentPager) != null) {
            viewPager.removeOnPageChangeListener(onPageChangeListener);
        }
        c1413a.onPageChangeListener = c1418f;
        ViewPager viewPager3 = c1413a.contentPager;
        if (viewPager3 != null) {
            viewPager3.addOnPageChangeListener(c1418f);
        }
        Dialog dialog = c1413a.getDialog();
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC1419g(flexInputFragment));
        }
        C1420h c1420h = new C1420h(flexInputFragment);
        C12238m.checkNotNullParameter(c1420h, "onKeyboardSelectedListener");
        c1413a.onKeyboardSelectedListener = c1420h;
    }

    /* JADX INFO: renamed from: h */
    public static final void m9289h(FlexInputFragment flexInputFragment, boolean z2) {
        Object obj;
        Fragment fragmentFindFragmentById = flexInputFragment.getChildFragmentManager().findFragmentById(C11170R.f.expression_tray_container);
        if (fragmentFindFragmentById != null && fragmentFindFragmentById.isAdded() && fragmentFindFragmentById.isResumed()) {
            if (!(fragmentFindFragmentById instanceof InterfaceC1430c)) {
                obj = fragmentFindFragmentById;
                obj = null;
            }
            obj = fragmentFindFragmentById;
            InterfaceC1430c interfaceC1430c = (InterfaceC1430c) obj;
            if (interfaceC1430c != null) {
                interfaceC1430c.isShown(z2);
            }
        }
    }

    @Override // p007b.p076b.p077a.InterfaceC1429b
    /* JADX INFO: renamed from: b */
    public SelectionAggregator<Attachment<Object>> mo396b() {
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = this.attachmentPreviewAdapter;
        if (attachmentPreviewAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
        }
        return attachmentPreviewAdapter.selectionAggregator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p076b.p077a.InterfaceC1429b
    /* JADX INFO: renamed from: f */
    public void mo397f(Attachment<? extends Object> attachment) {
        C12238m.checkNotNullParameter(attachment, "attachment");
        DialogFragment dialogFragment = (DialogFragment) getChildFragmentManager().findFragmentByTag("Add Content");
        SelectionCoordinator<T, ?> selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        mo396b().registerSelectionCoordinator(selectionCoordinator);
        selectionCoordinator.m9300c(attachment, 0);
        selectionCoordinator.itemSelectionListener.unregister();
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onAttachmentsUpdated(mo396b().getAttachments());
        }
        m9291j().f2175d.post(new RunnableC11182b(dialogFragment));
    }

    @Override // p007b.p076b.p077a.InterfaceC1429b
    public FileManager getFileManager() {
        FileManager fileManager = this.fileManager;
        if (fileManager == null) {
            C12238m.throwUninitializedPropertyAccessException("fileManager");
        }
        return fileManager;
    }

    @Override // p007b.p076b.p077a.InterfaceC1429b
    public boolean hasMediaPermissions() {
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            return flexInputViewModel.hasMediaPermissions();
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public final void m9290i(Function0<Unit> onViewCreatedUpdate) {
        C12238m.checkNotNullParameter(onViewCreatedUpdate, "onViewCreatedUpdate");
        try {
            LinearLayout linearLayout = m9291j().f2177f;
            onViewCreatedUpdate.invoke();
        } catch (IllegalStateException unused) {
            this.onViewCreatedUpdates.add(onViewCreatedUpdate);
        }
    }

    /* JADX INFO: renamed from: j */
    public final C1444a m9291j() {
        return (C1444a) this.binding.getValue((Fragment) this, f22054j[0]);
    }

    /* JADX INFO: renamed from: k */
    public final C1434d.a[] m9292k() {
        C1434d.a[] aVarArr = this.f22062r;
        if (aVarArr == null) {
            C12238m.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        if (aVarArr.length == 0) {
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            C12238m.checkNotNullParameter(contextRequireContext, "context");
            return new C1434d.a[]{new C1431a(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C11170R.b.ic_flex_input_image, 0, 2, (Object) null), C11170R.h.attachment_media), new C1432b(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C11170R.b.ic_flex_input_file, 0, 2, (Object) null), C11170R.h.attachment_files), new C1433c(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C11170R.b.ic_flex_input_add_a_photo, 0, 2, (Object) null), C11170R.h.camera)};
        }
        C1434d.a[] aVarArr2 = this.f22062r;
        if (aVarArr2 == null) {
            C12238m.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        return aVarArr2;
    }

    /* JADX INFO: renamed from: l */
    public final FlexEditText m9293l() {
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            C12238m.throwUninitializedPropertyAccessException("inputEt");
        }
        return flexEditText;
    }

    /* JADX INFO: renamed from: m */
    public final boolean m9294m() {
        View view;
        if (!isAdded() || isHidden() || (view = getView()) == null) {
            return false;
        }
        return view.getVisibility() == 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C11170R.g.flex_input_widget, container, false);
        View viewFindViewById = viewInflate.findViewById(C11170R.f.text_input);
        C12238m.checkNotNullExpressionValue(viewFindViewById, "root.findViewById(R.id.text_input)");
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
            this.stateSubscription = flexInputViewModel.observeState().m11112r().m11096V(new C1426n(new C11184d(this)));
            FlexInputViewModel flexInputViewModel2 = this.viewModel;
            if (flexInputViewModel2 != null) {
                this.eventSubscription = flexInputViewModel2.observeEvents().m11096V(new C1426n(new C11185e(this)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        C12238m.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("FlexInput.ATTACHMENTS", mo396b().getAttachments());
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            C12238m.throwUninitializedPropertyAccessException("inputEt");
        }
        outState.putString("FlexInput.TEXT", String.valueOf(flexEditText.getText()));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FlexInputViewModel flexInputViewModel;
        C12238m.checkNotNullParameter(view, "view");
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = new AttachmentPreviewAdapter<>(false, null, null, 7);
        attachmentPreviewAdapter.selectionAggregator.addItemSelectionListener(new C1425m(this));
        this.attachmentPreviewAdapter = attachmentPreviewAdapter;
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            C12238m.throwUninitializedPropertyAccessException("inputEt");
        }
        TextWatcherKt.addBindedTextWatcher(flexEditText, this, new C11186f());
        FlexEditText flexEditText2 = this.inputEt;
        if (flexEditText2 == null) {
            C12238m.throwUninitializedPropertyAccessException("inputEt");
        }
        flexEditText2.setOnClickListener(new ViewOnClickListenerC11181a(0, this));
        m9291j().f2173b.setOnClickListener(new ViewOnClickListenerC11181a(1, this));
        C1444a c1444aM9291j = m9291j();
        m9291j().f2180i.setOnClickListener(new ViewOnClickListenerC12411h(0, this));
        m9291j().f2186o.setOnClickListener(new ViewOnClickListenerC12411h(1, this));
        c1444aM9291j.f2183l.setOnClickListener(new ViewOnClickListenerC12411h(2, this));
        c1444aM9291j.f2184m.setOnClickListener(new ViewOnClickListenerC12411h(3, this));
        c1444aM9291j.f2179h.setOnClickListener(new ViewOnClickListenerC12411h(4, this));
        AppCompatImageButton appCompatImageButton = c1444aM9291j.f2173b;
        C12238m.checkNotNullExpressionValue(appCompatImageButton, "attachmentClearBtn");
        AppCompatImageButton appCompatImageButton2 = c1444aM9291j.f2183l;
        C12238m.checkNotNullExpressionValue(appCompatImageButton2, "galleryBtn");
        AppCompatImageButton appCompatImageButton3 = c1444aM9291j.f2184m;
        C12238m.checkNotNullExpressionValue(appCompatImageButton3, "giftBtn");
        AppCompatImageButton appCompatImageButton4 = c1444aM9291j.f2180i;
        C12238m.checkNotNullExpressionValue(appCompatImageButton4, "expressionBtn");
        FrameLayout frameLayout = c1444aM9291j.f2186o;
        C12238m.checkNotNullExpressionValue(frameLayout, "sendBtnContainer");
        AppCompatImageButton appCompatImageButton5 = c1444aM9291j.f2179h;
        C12238m.checkNotNullExpressionValue(appCompatImageButton5, "expandBtn");
        Iterator it = C12147n.listOf((Object[]) new View[]{appCompatImageButton, appCompatImageButton2, appCompatImageButton3, appCompatImageButton4, frameLayout, appCompatImageButton5}).iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnLongClickListener(new ViewOnLongClickListenerC1421i(this));
        }
        FrameLayout frameLayout2 = m9291j().f2182k;
        C12238m.checkNotNullExpressionValue(frameLayout2, "binding.expressionTrayContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        FrameLayout frameLayout3 = m9291j().f2182k;
        C12238m.checkNotNullExpressionValue(frameLayout3, "binding.expressionTrayContainer");
        Context context = frameLayout3.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.expressionTrayContainer.context");
        layoutParams2.height = (int) (DisplayUtils.getScreenSize(context).height() * 0.5f);
        FrameLayout frameLayout4 = m9291j().f2182k;
        C12238m.checkNotNullExpressionValue(frameLayout4, "binding.expressionTrayContainer");
        frameLayout4.setLayoutParams(layoutParams2);
        if (savedInstanceState != null) {
            ArrayList<? super Parcelable> parcelableArrayList = savedInstanceState.getParcelableArrayList("FlexInput.ATTACHMENTS");
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                mo396b().initFrom(parcelableArrayList);
            }
            FlexInputViewModel flexInputViewModel2 = this.viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(mo396b().getAttachments());
            }
            String string = savedInstanceState.getString("FlexInput.TEXT");
            if (string != null && (flexInputViewModel = this.viewModel) != null) {
                flexInputViewModel.onInputTextChanged(string, null);
            }
        }
        FrameLayout frameLayout5 = m9291j().f2182k;
        C12238m.checkNotNullExpressionValue(frameLayout5, "binding.expressionTrayContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout5);
        ViewCompat.setOnApplyWindowInsetsListener(m9291j().f2178g, C1427o.f2139a);
        ViewCompat.setOnApplyWindowInsetsListener(m9291j().f2177f, new C1428p(this));
        Iterator<Function0<Unit>> it2 = this.onViewCreatedUpdates.iterator();
        while (it2.hasNext()) {
            it2.next().invoke();
        }
        this.onViewCreatedUpdates.clear();
    }

    @Override // p007b.p076b.p077a.InterfaceC1429b
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.requestMediaPermissions(onSuccess);
        }
    }
}
