package KodlamaIo.hrms.core.result;

public class ErrorResult extends Result {
	
	public ErrorResult() {
		super(true);
	}

	public ErrorResult(String message) {
		super(true, message);

	}

}
