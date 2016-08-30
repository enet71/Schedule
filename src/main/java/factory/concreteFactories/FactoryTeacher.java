package factory.concreteFactories;

import factory.FactoryDB;
import factory.abstractProducts.Create;
import factory.abstractProducts.Edit;
import factory.abstractProducts.Remove;
import factory.abstractProducts.Select;
import factory.products.teacher.CreateTeacher;
import factory.products.teacher.EditTeacher;
import factory.products.teacher.RemoveTeacher;
import factory.products.teacher.SelectTeacher;

public class FactoryTeacher implements FactoryDB{
    public Create tableCreate() {
        return new CreateTeacher();
    }

    public Edit tableEdit() {
        return new EditTeacher();
    }

    public Remove tableRemove() {
        return new RemoveTeacher();
    }

    public Select tableSelect() {
        return new SelectTeacher();
    }
}
