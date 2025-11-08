declare module '@apiverve/babynamegenerator' {
  export interface babynamegeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface babynamegeneratorResponse {
    status: string;
    error: string | null;
    data: any;
    code?: number;
  }

  export default class babynamegeneratorWrapper {
    constructor(options: babynamegeneratorOptions);

    execute(callback: (error: any, data: babynamegeneratorResponse | null) => void): Promise<babynamegeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: babynamegeneratorResponse | null) => void): Promise<babynamegeneratorResponse>;
    execute(query?: Record<string, any>): Promise<babynamegeneratorResponse>;
  }
}
