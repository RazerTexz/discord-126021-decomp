package com.discord.widgets.phone;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.w;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPhoneCountryCodeBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0)};
    public static final WidgetPhoneCountryCodeBottomSheet$Companion Companion = new WidgetPhoneCountryCodeBottomSheet$Companion(null);
    private final PhoneCountryCodeAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> nameFilterSubject;

    public WidgetPhoneCountryCodeBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPhoneCountryCodeBottomSheet$binding$2.INSTANCE, null, 2, null);
        BehaviorSubject<String> behaviorSubjectL0 = BehaviorSubject.l0("");
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.nameFilterSubject = behaviorSubjectL0;
        this.adapter = new PhoneCountryCodeAdapter();
    }

    public static final /* synthetic */ void access$configureUI(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet, String str) {
        widgetPhoneCountryCodeBottomSheet.configureUI(str);
    }

    public static final /* synthetic */ BehaviorSubject access$getNameFilterSubject$p(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet) {
        return widgetPhoneCountryCodeBottomSheet.nameFilterSubject;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0041  */
    private final void configureUI(String filter) {
        boolean z2;
        StorePhone phone = StoreStream.Companion.getPhone();
        List<PhoneCountryCode> countryCodes = phone.getCountryCodes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = countryCodes.iterator();
        while (true) {
            if (!it.hasNext()) {
                getBinding().f2509b.setHasFixedSize(false);
                RecyclerView recyclerView = getBinding().f2509b;
                m.checkNotNullExpressionValue(recyclerView, "binding.phoneCountryCodeRecycler");
                recyclerView.setAdapter(this.adapter);
                this.adapter.configure(arrayList, new WidgetPhoneCountryCodeBottomSheet$configureUI$1(this, phone));
                return;
            }
            Object next = it.next();
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
            if (!w.contains((CharSequence) phoneCountryCode.getName(), (CharSequence) filter, true)) {
                PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
                Context contextRequireContext = requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                z2 = w.contains((CharSequence) phoneUtils.getTranslatedStringForCountry(phoneCountryCode, contextRequireContext), (CharSequence) filter, true);
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    private final WidgetPhoneCountryCodeBottomSheetBinding getBinding() {
        return (WidgetPhoneCountryCodeBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_phone_country_code_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.phoneCountryCodeSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetPhoneCountryCodeBottomSheet$onResume$1(this));
        Observable<String> observableP = this.nameFilterSubject.p(200L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "nameFilterSubject.deboun…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), WidgetPhoneCountryCodeBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetPhoneCountryCodeBottomSheet$onResume$2(this), 62, (Object) null);
        configureUI("");
    }
}
