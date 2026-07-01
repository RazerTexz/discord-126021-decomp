package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetSettingsLanguageSelectBinding;
import com.discord.databinding.WidgetSettingsLanguageSelectItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsLanguageSelect.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String REQUEST_KEY_USER_LOCALE = "REQUEST_KEY_USER_LOCALE";
    private static final String RESULT_KEY_USE_LOCALE = "INTENT_EXTRA_LOCALE";
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final WidgetSettingsLanguageSelect dialog;

        /* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
        public static final class AdapterItemLocale extends MGRecyclerViewHolder<Adapter, Model.Item> {
            private final WidgetSettingsLanguageSelectItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AdapterItemLocale(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i2 = R.id.flag_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.flag_icon);
                if (imageView != null) {
                    i2 = R.id.flag_icon_barrier;
                    Barrier barrier = (Barrier) view.findViewById(R.id.flag_icon_barrier);
                    if (barrier != null) {
                        i2 = R.id.settings_language_select_item_name;
                        TextView textView = (TextView) view.findViewById(R.id.settings_language_select_item_name);
                        if (textView != null) {
                            i2 = R.id.settings_language_select_item_name_localized;
                            TextView textView2 = (TextView) view.findViewById(R.id.settings_language_select_item_name_localized);
                            if (textView2 != null) {
                                WidgetSettingsLanguageSelectItemBinding widgetSettingsLanguageSelectItemBinding = new WidgetSettingsLanguageSelectItemBinding((ConstraintLayout) view, imageView, barrier, textView, textView2);
                                Intrinsics3.checkNotNullExpressionValue(widgetSettingsLanguageSelectItemBinding, "WidgetSettingsLanguageSe…temBinding.bind(itemView)");
                                this.binding = widgetSettingsLanguageSelectItemBinding;
                                return;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(AdapterItemLocale adapterItemLocale) {
                return (Adapter) adapterItemLocale.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final Model.Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetSettingsLanguageSelect.Adapter.AdapterItemLocale.access$getAdapter$p(this.this$0).dialog.onLocaleSelected(data.getLocale());
                    }
                });
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsLanguageSelectItemName");
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                WidgetSettingsLanguage.Companion companion = WidgetSettingsLanguage.INSTANCE;
                textView.setText(context.getString(companion.getLocaleResId(data.getLocale())));
                TextView textView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsLanguageSelectItemNameLocalized");
                textView2.setText(companion.getAsStringInLocale(data.getLocale()));
                this.binding.f2629b.setImageResource(companion.getLocaleFlagResId(data.getLocale()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, WidgetSettingsLanguageSelect widgetSettingsLanguageSelect) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            Intrinsics3.checkNotNullParameter(widgetSettingsLanguageSelect, "dialog");
            this.dialog = widgetSettingsLanguageSelect;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public AdapterItemLocale onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new AdapterItemLocale(R.layout.widget_settings_language_select_item, this);
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, Function1<? super String, Unit> onLocaleSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onLocaleSelected, "onLocaleSelected");
            Fragment2.setFragmentResultListener(fragment, WidgetSettingsLanguageSelect.REQUEST_KEY_USER_LOCALE, new WidgetSettingsLanguageSelect3(onLocaleSelected));
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetSettingsLanguageSelect widgetSettingsLanguageSelect = new WidgetSettingsLanguageSelect();
            widgetSettingsLanguageSelect.setArguments(new Bundle());
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetSettingsLanguageSelect.show(parentFragmentManager, WidgetSettingsLanguageSelect.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
    public static final class Model {
        public static final Model INSTANCE = new Model();

        /* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
        public static final /* data */ class Item implements MGRecyclerDataPayload {
            private final String key;
            private final String locale;
            private final int type;

            public Item(String str) {
                Intrinsics3.checkNotNullParameter(str, "locale");
                this.locale = str;
                this.key = str;
            }

            public static /* synthetic */ Item copy$default(Item item, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.locale;
                }
                return item.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getLocale() {
                return this.locale;
            }

            public final Item copy(String locale) {
                Intrinsics3.checkNotNullParameter(locale, "locale");
                return new Item(locale);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Item) && Intrinsics3.areEqual(this.locale, ((Item) other).locale);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getLocale() {
                return this.locale;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String str = this.locale;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("Item(locale="), this.locale, ")");
            }
        }

        private Model() {
        }

        public final List<Item> getLocales() {
            List listListOf = Collections2.listOf((Object[]) new String[]{"da", "de", "en-GB", "en-US", "es-ES", "fr", "hr", "it", "lt", "hu", "nl", "no", "pl", "pt-BR", "ro", "fi", "sv-SE", "vi", "tr", "cs", "el", "bg", "ru", "uk", "ja", "zh-TW", "th", "zh-CN", "ko", "hi"});
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList.add(new Item((String) it.next()));
            }
            return arrayList;
        }
    }

    public WidgetSettingsLanguageSelect() {
        super(R.layout.widget_settings_language_select);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsLanguageSelect4.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsLanguageSelectBinding getBinding() {
        return (WidgetSettingsLanguageSelectBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onLocaleSelected(String locale) {
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_KEY_USE_LOCALE, locale);
        Fragment2.setFragmentResult(this, REQUEST_KEY_USER_LOCALE, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().f2628b;
        Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.settingsLanguageSelectList");
        Adapter adapter = (Adapter) companion.configure(new Adapter(maxHeightRecyclerView, this));
        this.adapter = adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter.setData(Model.INSTANCE.getLocales());
    }
}
