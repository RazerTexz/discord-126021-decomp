package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$configureCommandBrowser$1 extends o implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$configureCommandBrowser$1(InputAutocomplete inputAutocomplete) {
        super(2);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2) {
        Long lAccess$getCurrentlySelectedCategory;
        if (i >= 0 && (lAccess$getCurrentlySelectedCategory = InputAutocomplete.access$getCurrentlySelectedCategory(this.this$0, i)) != null) {
            long jLongValue = lAccess$getCurrentlySelectedCategory.longValue();
            InputAutocomplete.access$getCategoriesAdapter$p(this.this$0).selectApplication(jLongValue);
            int positionOfApplication = InputAutocomplete.access$getCategoriesAdapter$p(this.this$0).getPositionOfApplication(jLongValue);
            if (positionOfApplication >= 0) {
                InputAutocomplete.access$getCommandBrowserAppsRecyclerView$p(this.this$0).smoothScrollToPosition(positionOfApplication);
            }
        }
        InputAutocomplete.access$getViewModel$p(this.this$0).onCommandsBrowserScroll(i, i2, InputAutocomplete.access$getAutocompleteAdapter$p(this.this$0).getPageSize());
    }
}
