module jmp.cloud.service.impl {
	requires transitive jmp.service.api;
    requires jmp.dto;
    exports com.jmp.serviceimpl;
    
    provides com.jmp.serviceapi.BankService
    with com.jmp.serviceimpl.ServiceImpl;
}
