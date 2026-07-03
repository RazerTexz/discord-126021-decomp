package com.discord.widgets.settings.premium;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetOutboundPromoTermsBinding;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p050t.p052b.p054b.C1303e;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms extends AppBottomSheet {
    private static final String ARG_CONTENT = "ARG_CONTENT";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Parser<UrlNode.RenderContext, Node<UrlNode.RenderContext>, MessageParseState> parser;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetOutboundPromoTerms.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOutboundPromoTermsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(String content, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(content, "content");
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetOutboundPromoTerms widgetOutboundPromoTerms = new WidgetOutboundPromoTerms();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetOutboundPromoTerms.ARG_CONTENT, content);
            widgetOutboundPromoTerms.setArguments(bundle);
            widgetOutboundPromoTerms.show(fragmentManager, WidgetOutboundPromoTerms.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetOutboundPromoTerms() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetOutboundPromoTerms$binding$2.INSTANCE, null, 2, null);
        Parser parser = new Parser(false, 1, null);
        Rules rules = Rules.INSTANCE;
        this.parser = parser.addRule(rules.createMaskedLinkRule()).addRule(rules.createUrlRule()).addRules(C1303e.m372b(false, false, 3));
    }

    private final WidgetOutboundPromoTermsBinding getBinding() {
        return (WidgetOutboundPromoTermsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final UrlNode.RenderContext getRenderContext() {
        return new UrlNode.RenderContext() { // from class: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$renderContext$1
            private final Context context;
            private final int linkColorAttrResId;
            private final Function3<Context, String, String, Unit> onClickUrl = WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1.INSTANCE;
            private final Function1<String, Unit> onLongPressUrl;

            {
                Context contextRequireContext = this.this$0.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                this.context = contextRequireContext;
                this.linkColorAttrResId = C5419R.attr.colorTextLink;
                this.onLongPressUrl = WidgetOutboundPromoTerms$renderContext$1$onLongPressUrl$1.INSTANCE;
            }

            @Override // com.discord.utilities.textprocessing.node.BasicRenderContext, com.discord.utilities.textprocessing.node.UserMentionNode.RenderContext, com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
            public Context getContext() {
                return this.context;
            }

            @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
            public int getLinkColorAttrResId() {
                return this.linkColorAttrResId;
            }

            @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
            public Function3<Context, String, String, Unit> getOnClickUrl() {
                return this.onClickUrl;
            }

            @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
            public Function1<String, Unit> getOnLongPressUrl() {
                return this.onLongPressUrl;
            }
        };
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_outbound_promo_terms;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17346b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetOutboundPromoTerms.this.dismiss();
            }
        });
        String string = getArgumentsOrDefault().getString(ARG_CONTENT, "");
        Parser<UrlNode.RenderContext, Node<UrlNode.RenderContext>, MessageParseState> parser = this.parser;
        C12238m.checkNotNullExpressionValue(string, "content");
        getBinding().f17347c.setDraweeSpanStringBuilder(AstRenderer.render(Parser.parse$default(parser, string, MessageParseState.INSTANCE.getInitialState(), null, 4, null), getRenderContext()));
    }
}
