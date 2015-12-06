package nyc.c4q.ramonaharrison.itunessearch;

import javax.inject.Inject;
import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
 * Created by Ramona Harrison
 * on 12/5/15.
 */

public class DependencyInjectionII {
    public static void main(String[] args) {
        ObjectGraph graph = ObjectGraph.create(new MyModule(23));
        A a = graph.get(A.class);
        a.doStuff();

//        D d = new D();
//        B b = new B(d);
//        C c = new C(d);
//        A a = new A(b, c);
//        a.doStuff();

    }
}


@Module(injects = A.class)
class MyModule {
    int foo;

    public MyModule(int foo) {
        this.foo = foo;
    }

    @Provides D getD() {return new D(foo);}
    @Provides B providesB(D d) {return new B(d);}
    @Provides C providesC(D d) {return new C(d);}
    @Provides A providesA(B b, C c) { return new A(b,c); }

}


class A {
    @Inject
    public A(B b, C c) {
    }

    void doStuff() {
        System.out.println("Hello world");
    }
}

class B {
    @Inject
    public B(D d) {
    }
}

class C {
    @Inject
    public C(D d) {
    }
}

class D{
    int foo;
    public D(int foo) {
        this.foo = foo;
    }
}
