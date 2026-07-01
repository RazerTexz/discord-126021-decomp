package com.discord.widgets.botuikit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.botuikit.ActionRowComponent;
import com.discord.api.botuikit.TextComponent;
import com.discord.api.botuikit.TextStyle;
import com.discord.app.AppFragment;
import com.discord.databinding.BotUikitTextInputBinding;
import com.discord.databinding.ViewInteractionModalBinding;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.t.o;
import d0.t.t;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(ModalComponent.class, "binding", "getBinding()Lcom/discord/databinding/ViewInteractionModalBinding;", 0)};
    public static final ModalComponent$Companion Companion = new ModalComponent$Companion(null);
    private static final String EXTRA_OPTIONS = "extra_options";

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String sentNonce;

    public ModalComponent() {
        this(0, 1, null);
    }

    public ModalComponent(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ModalComponent$binding$2.INSTANCE, null, 2, null);
        this.args = g.lazy(new ModalComponent$$special$$inlined$args$1(this, "extra_options"));
    }

    public static final /* synthetic */ ViewInteractionModalBinding access$getBinding$p(ModalComponent modalComponent) {
        return modalComponent.getBinding();
    }

    public static final /* synthetic */ String access$getSentNonce$p(ModalComponent modalComponent) {
        return modalComponent.sentNonce;
    }

    public static final /* synthetic */ void access$setSentNonce$p(ModalComponent modalComponent, String str) {
        modalComponent.sentNonce = str;
    }

    private final ViewInteractionModalBinding getBinding() {
        return (ViewInteractionModalBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final ModalComponent$Options getArgs() {
        return (ModalComponent$Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(getArgs().getModal().getTitle());
        SimpleDraweeView simpleDraweeView = getBinding().e;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.icon");
        simpleDraweeView.setContentDescription(getArgs().getModal().getApplication().getName());
        SimpleDraweeView simpleDraweeView2 = getBinding().e;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.icon");
        IconUtils.setApplicationIcon(simpleDraweeView2, StoreApplicationCommandsKt.toDomainApplication(getArgs().getModal().getApplication()));
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.warning");
        b.n(textView2, 2131892186, new Object[]{getArgs().getModal().getApplication().getName()}, null, 4);
        List listFilterIsInstance = t.filterIsInstance(getArgs().getModal().b(), ActionRowComponent.class);
        ArrayList<TextComponent> arrayList = new ArrayList();
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            Object orNull = u.getOrNull(((ActionRowComponent) it.next()).b(), 0);
            if (!(orNull instanceof TextComponent)) {
                orNull = null;
            }
            TextComponent textComponent = (TextComponent) orNull;
            if (textComponent != null) {
                arrayList.add(textComponent);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        for (TextComponent textComponent2 : arrayList) {
            View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.bot_uikit_text_input, (ViewGroup) null, false);
            int i = R$id.edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(R$id.edit_text);
            if (textInputEditText != null) {
                i = R$id.label;
                TextView textView3 = (TextView) viewInflate.findViewById(R$id.label);
                if (textView3 != null) {
                    i = 2131364238;
                    TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(2131364238);
                    if (textInputLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        BotUikitTextInputBinding botUikitTextInputBinding = new BotUikitTextInputBinding(linearLayout, textInputEditText, textView3, textInputLayout);
                        m.checkNotNullExpressionValue(botUikitTextInputBinding, "BotUikitTextInputBinding…r.from(requireContext()))");
                        m.checkNotNullExpressionValue(textView3, "textInput.label");
                        textView3.setText(textComponent2.getLabel());
                        m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        textInputLayout.setCounterMaxLength(textComponent2.getMaxLength());
                        m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new ModalComponent$onViewBound$components$2$1(botUikitTextInputBinding));
                        textInputEditText.setText(textComponent2.getValue());
                        m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                        textInputEditText.setHint(textComponent2.getPlaceholder());
                        if (textComponent2.getStyle() == TextStyle.PARAGRAPH) {
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(5);
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(131073);
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMinHeight(DimenUtils.dpToPixels(96));
                        } else {
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(1);
                            m.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(1);
                        }
                        getBinding().c.addView(linearLayout);
                        arrayList2.add(new Pair(textComponent2, botUikitTextInputBinding));
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        getBinding().f2200b.setOnClickListener(new ModalComponent$onViewBound$1(this));
        getBinding().f.setOnClickListener(new ModalComponent$onViewBound$2(this, arrayList2, view));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getInteractions().observeSentInteractions(), this, null, 2, null), ModalComponent.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ModalComponent$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }

    public /* synthetic */ ModalComponent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R$layout.view_interaction_modal : i);
    }
}
