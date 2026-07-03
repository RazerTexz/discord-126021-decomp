package com.discord.widgets.botuikit;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.botuikit.ActionRowComponent;
import com.discord.api.botuikit.TextComponent;
import com.discord.api.botuikit.TextStyle;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.app.AppFragment;
import com.discord.databinding.BotUikitTextInputBinding;
import com.discord.databinding.ViewInteractionModalBinding;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12162t;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(ModalComponent.class, "binding", "getBinding()Lcom/discord/databinding/ViewInteractionModalBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_OPTIONS = "extra_options";

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String sentNonce;

    /* JADX INFO: compiled from: ModalComponent.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, Options options) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(options, "options");
            Intent intent = new Intent();
            intent.putExtra("extra_options", options);
            C0870j.m156d(context, ModalComponent.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ModalComponent.kt */
    public static final /* data */ class Options implements Parcelable {
        public static final Parcelable.Creator<Options> CREATOR = new Creator();
        private final InteractionModalCreate modal;

        public static class Creator implements Parcelable.Creator<Options> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options createFromParcel(Parcel parcel) {
                C12238m.checkNotNullParameter(parcel, "in");
                return new Options((InteractionModalCreate) parcel.readSerializable());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options[] newArray(int i) {
                return new Options[i];
            }
        }

        public Options(InteractionModalCreate interactionModalCreate) {
            C12238m.checkNotNullParameter(interactionModalCreate, "modal");
            this.modal = interactionModalCreate;
        }

        public static /* synthetic */ Options copy$default(Options options, InteractionModalCreate interactionModalCreate, int i, Object obj) {
            if ((i & 1) != 0) {
                interactionModalCreate = options.modal;
            }
            return options.copy(interactionModalCreate);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InteractionModalCreate getModal() {
            return this.modal;
        }

        public final Options copy(InteractionModalCreate modal) {
            C12238m.checkNotNullParameter(modal, "modal");
            return new Options(modal);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Options) && C12238m.areEqual(this.modal, ((Options) other).modal);
            }
            return true;
        }

        public final InteractionModalCreate getModal() {
            return this.modal;
        }

        public int hashCode() {
            InteractionModalCreate interactionModalCreate = this.modal;
            if (interactionModalCreate != null) {
                return interactionModalCreate.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Options(modal=");
            sbM833U.append(this.modal);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            C12238m.checkNotNullParameter(parcel, "parcel");
            parcel.writeSerializable(this.modal);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreApplicationInteractions.SentInteractionState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreApplicationInteractions.SentInteractionState.SUCCESS.ordinal()] = 1;
            iArr[StoreApplicationInteractions.SentInteractionState.FAILURE.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2 */
    /* JADX INFO: compiled from: ModalComponent.kt */
    public static final class ViewOnClickListenerC72732 implements View.OnClickListener {
        public final /* synthetic */ List $components;
        public final /* synthetic */ View $view;

        /* JADX INFO: renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: ModalComponent.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<String, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                C12238m.checkNotNullParameter(str, "nonce");
                ModalComponent.this.sentNonce = str;
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: ModalComponent.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ViewOnClickListenerC72732.this.$view.post(new Runnable() { // from class: com.discord.widgets.botuikit.ModalComponent.onViewBound.2.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ModalComponent.this.sentNonce = null;
                        LinearLayout linearLayout = ModalComponent.this.getBinding().f15502d;
                        C12238m.checkNotNullExpressionValue(linearLayout, "binding.error");
                        linearLayout.setVisibility(0);
                        MaterialButton materialButton = ModalComponent.this.getBinding().f15504f;
                        C12238m.checkNotNullExpressionValue(materialButton, "binding.submit");
                        materialButton.setEnabled(true);
                    }
                });
            }
        }

        public ViewOnClickListenerC72732(List list, View view) {
            this.$components = list;
            this.$view = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            boolean z2 = true;
            for (Pair pair : this.$components) {
                TextComponent textComponent = (TextComponent) pair.component1();
                BotUikitTextInputBinding botUikitTextInputBinding = (BotUikitTextInputBinding) pair.component2();
                TextInputEditText textInputEditText = botUikitTextInputBinding.f15015b;
                C12238m.checkNotNullExpressionValue(textInputEditText, "text.editText");
                String strValueOf = String.valueOf(textInputEditText.getText());
                if (strValueOf.length() == 0) {
                    if (C12238m.areEqual(textComponent.getRequired(), Boolean.TRUE)) {
                        TextInputLayout textInputLayout = botUikitTextInputBinding.f15017d;
                        C12238m.checkNotNullExpressionValue(textInputLayout, "text.layout");
                        textInputLayout.setError(C1107b.m213e(ModalComponent.this, C5419R.string.form_length_error, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
                        z2 = false;
                    }
                } else if (strValueOf.length() < textComponent.getMinLength() || strValueOf.length() > textComponent.getMaxLength()) {
                    TextInputLayout textInputLayout2 = botUikitTextInputBinding.f15017d;
                    C12238m.checkNotNullExpressionValue(textInputLayout2, "text.layout");
                    textInputLayout2.setError(C1107b.m213e(ModalComponent.this, C5419R.string.form_length_error, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
                    z2 = false;
                }
                arrayList.add(new Pair(textComponent.getCustomId(), strValueOf));
            }
            if (z2) {
                ModalComponent.this.sentNonce = null;
                LinearLayout linearLayout = ModalComponent.this.getBinding().f15502d;
                C12238m.checkNotNullExpressionValue(linearLayout, "binding.error");
                linearLayout.setVisibility(8);
                MaterialButton materialButton = ModalComponent.this.getBinding().f15504f;
                C12238m.checkNotNullExpressionValue(materialButton, "binding.submit");
                materialButton.setEnabled(false);
                StoreStream.INSTANCE.getInteractions().sendModalInteraction(ModalComponent.this.getArgs().getModal(), arrayList, new AnonymousClass2(), new AnonymousClass3());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: ModalComponent.kt */
    public static final class C72741 extends AbstractC12240o implements Function1<Map<String, ? extends StoreApplicationInteractions.SentInteraction>, Unit> {
        public C72741() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreApplicationInteractions.SentInteraction> map) {
            invoke2((Map<String, StoreApplicationInteractions.SentInteraction>) map);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<String, StoreApplicationInteractions.SentInteraction> map) {
            StoreApplicationInteractions.SentInteraction sentInteraction;
            FragmentActivity fragmentActivityM95e;
            C12238m.checkNotNullParameter(map, "sentInteractions");
            String str = ModalComponent.this.sentNonce;
            if (str == null || (sentInteraction = map.get(str)) == null) {
                return;
            }
            int iOrdinal = sentInteraction.getState().ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2 && (fragmentActivityM95e = ModalComponent.this.m95e()) != null) {
                    fragmentActivityM95e.finish();
                    return;
                }
                return;
            }
            ModalComponent.this.sentNonce = null;
            LinearLayout linearLayout = ModalComponent.this.getBinding().f15502d;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.error");
            linearLayout.setVisibility(0);
            MaterialButton materialButton = ModalComponent.this.getBinding().f15504f;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.submit");
            materialButton.setEnabled(true);
        }
    }

    public ModalComponent() {
        this(0, 1, null);
    }

    public ModalComponent(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ModalComponent$binding$2.INSTANCE, null, 2, null);
        this.args = C12083g.lazy(new ModalComponent$$special$$inlined$args$1(this, "extra_options"));
    }

    private final ViewInteractionModalBinding getBinding() {
        return (ViewInteractionModalBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Options getArgs() {
        return (Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15505g;
        C12238m.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(getArgs().getModal().getTitle());
        SimpleDraweeView simpleDraweeView = getBinding().f15503e;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.icon");
        simpleDraweeView.setContentDescription(getArgs().getModal().getApplication().getName());
        SimpleDraweeView simpleDraweeView2 = getBinding().f15503e;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.icon");
        IconUtils.setApplicationIcon(simpleDraweeView2, StoreApplicationCommandsKt.toDomainApplication(getArgs().getModal().getApplication()));
        TextView textView2 = getBinding().f15506h;
        C12238m.checkNotNullExpressionValue(textView2, "binding.warning");
        C1107b.m221m(textView2, C5419R.string.interaction_form_submission_application, new Object[]{getArgs().getModal().getApplication().getName()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        List listFilterIsInstance = C12162t.filterIsInstance(getArgs().getModal().m8010b(), ActionRowComponent.class);
        ArrayList<TextComponent> arrayList = new ArrayList();
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            Object orNull = C12163u.getOrNull(((ActionRowComponent) it.next()).m7594b(), 0);
            if (!(orNull instanceof TextComponent)) {
                orNull = null;
            }
            TextComponent textComponent = (TextComponent) orNull;
            if (textComponent != null) {
                arrayList.add(textComponent);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        for (TextComponent textComponent2 : arrayList) {
            View viewInflate = LayoutInflater.from(requireContext()).inflate(C5419R.layout.bot_uikit_text_input, (ViewGroup) null, false);
            int i = C5419R.id.edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(C5419R.id.edit_text);
            if (textInputEditText != null) {
                i = C5419R.id.label;
                TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.label);
                if (textView3 != null) {
                    i = C5419R.id.layout;
                    TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(C5419R.id.layout);
                    if (textInputLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        BotUikitTextInputBinding botUikitTextInputBinding = new BotUikitTextInputBinding(linearLayout, textInputEditText, textView3, textInputLayout);
                        C12238m.checkNotNullExpressionValue(botUikitTextInputBinding, "BotUikitTextInputBinding…r.from(requireContext()))");
                        C12238m.checkNotNullExpressionValue(textView3, "textInput.label");
                        textView3.setText(textComponent2.getLabel());
                        C12238m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        textInputLayout.setCounterMaxLength(textComponent2.getMaxLength());
                        C12238m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new ModalComponent$onViewBound$components$2$1(botUikitTextInputBinding));
                        textInputEditText.setText(textComponent2.getValue());
                        C12238m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                        textInputEditText.setHint(textComponent2.getPlaceholder());
                        if (textComponent2.getStyle() == TextStyle.PARAGRAPH) {
                            C12238m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(5);
                            C12238m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(131073);
                            C12238m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMinHeight(DimenUtils.dpToPixels(96));
                        } else {
                            C12238m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(1);
                            C12238m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(1);
                        }
                        getBinding().f15501c.addView(linearLayout);
                        arrayList2.add(new Pair(textComponent2, botUikitTextInputBinding));
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        getBinding().f15500b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.botuikit.ModalComponent.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = ModalComponent.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
        getBinding().f15504f.setOnClickListener(new ViewOnClickListenerC72732(arrayList2, view));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getInteractions().observeSentInteractions(), this, null, 2, null), (Class<?>) ModalComponent.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72741());
    }

    public /* synthetic */ ModalComponent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C5419R.layout.view_interaction_modal : i);
    }
}
