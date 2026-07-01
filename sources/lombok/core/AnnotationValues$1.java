package lombok.core;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationValues$1.SCL.lombok */
class AnnotationValues$1 implements InvocationHandler {
    final /* synthetic */ AnnotationValues this$0;

    AnnotationValues$1(AnnotationValues annotationValues) {
        this.this$0 = annotationValues;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        AnnotationValues$AnnotationValue v = (AnnotationValues$AnnotationValue) AnnotationValues.access$0(this.this$0).get(method.getName());
        if (v == null) {
            Object defaultValue = method.getDefaultValue();
            if (defaultValue != null) {
                return defaultValue;
            }
            throw AnnotationValues.access$1(v, method);
        }
        boolean isArray = false;
        Class<?> expected = method.getReturnType();
        Object array = null;
        if (expected.isArray()) {
            isArray = true;
            expected = expected.getComponentType();
            array = Array.newInstance(expected, v.valueGuesses.size());
        }
        if (!isArray && v.valueGuesses.size() > 1) {
            throw new AnnotationValues$AnnotationValueDecodeFail(v, "Expected a single value, but " + method.getName() + " has an array of values", -1);
        }
        if (v.valueGuesses.size() == 0 && !isArray) {
            Object defaultValue2 = method.getDefaultValue();
            if (defaultValue2 == null) {
                throw AnnotationValues.access$1(v, method);
            }
            return defaultValue2;
        }
        int idx = 0;
        Iterator<Object> it = v.valueGuesses.iterator();
        while (it.hasNext()) {
            Object guess = it.next();
            Object result = guess == null ? null : AnnotationValues.access$2(this.this$0, guess, expected, v, idx);
            if (!isArray) {
                if (result == null) {
                    Object defaultValue3 = method.getDefaultValue();
                    if (defaultValue3 == null) {
                        throw AnnotationValues.access$1(v, method);
                    }
                    return defaultValue3;
                }
                return result;
            }
            if (result == null) {
                if (v.valueGuesses.size() == 1) {
                    Object defaultValue4 = method.getDefaultValue();
                    if (defaultValue4 == null) {
                        throw AnnotationValues.access$1(v, method);
                    }
                    return defaultValue4;
                }
                throw new AnnotationValues$AnnotationValueDecodeFail(v, "I can't make sense of this annotation value. Try using a fully qualified literal.", idx);
            }
            int i = idx;
            idx++;
            Array.set(array, i, result);
        }
        return array;
    }
}
