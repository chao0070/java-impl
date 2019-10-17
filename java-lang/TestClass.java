import java.io.*;
import java.util.*;
import java.util.function.*;
import java.lang.*;
import java.util.stream.*;

interface MyInterface {
	void myRun();
}

interface IFactory<T> {
	T create(int i, String s);
}

interface IProducer<T> {
	T produce();
}

interface IConfigurator<T> {
	void configure(T t);
}

class HigherOrderFunctions {
	public <T> IFactory<T> createFactory(IProducer<T> producer, IConfigurator<T> configurator) {
		return (i, s) -> {
			T instance = producer.produce();
			configurator.configure(instance);
			return instance;
		};
	}
}

public class TestClass {
	public static void main(String[] args) {
		MyInterface m = () -> {
			System.out.println("This is implemented");
		};
		Function<String, Integer> f = (s) -> {
			return Integer.parseInt(s);
		};
		System.out.println(f.apply("10"));
		m.myRun();
	}
}