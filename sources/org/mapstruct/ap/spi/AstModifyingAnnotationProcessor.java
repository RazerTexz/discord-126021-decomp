package org.mapstruct.ap.spi;

import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: app.apk:secondaryLoading.SCL.lombok/org/mapstruct/ap/spi/AstModifyingAnnotationProcessor.SCL.lombok */
public interface AstModifyingAnnotationProcessor {
    boolean isTypeComplete(TypeMirror typeMirror);
}
